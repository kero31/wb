/**
 * 
 */
package common.api.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import common.api.application.impl.PropertiesAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.exception.WebbatiException;

/**
 * 
 * Classe/Interface <b>Mail</b><br/>
 * Classe permettant de gérer les mails.
 */
public class Mail {
	private static final String SMTP_PORT_TLS = "587";
	private static final String SMTP_PORT_SSL = "465";

	/**
	 * 
	 * Constructeur.
	 */
	protected Mail() {
		super();
	}

	/**
	 * Envoie un mail avec les valeurs du fichier de properties
	 * 
	 * @param pEmailTo email To
	 * @param pMessageText message
	 * @param pSubject sujet
	 * @throws WebbatiException
	 */
	public static void sendMail(String pEmailTo, String pMessageText, String pSubject) throws WebbatiException {
		sendMail(pEmailTo, null, pMessageText, pSubject);
	}

	/**
	 * Envoie un mail avec les valeurs du fichier de properties et ajoute le cc
	 * 
	 * @param pEmailTo email To
	 * @param pEmailCc email Cc
	 * @param pMessageText message
	 * @param pSubject sujet
	 * @throws WebbatiException
	 */
	public static void sendMail(String pEmailTo, String pEmailCc, String pMessageText, String pSubject) throws WebbatiException {
		PropertiesAppImpl prop = ServiceBeanFactory.getServiceBean(PropertiesAppImpl.class);
		sendMail(prop.getProperty(IPropertiesApp.EMAIL_FROM), pEmailTo, pEmailCc, pMessageText, pSubject,
				prop.getProperty(IPropertiesApp.EMAIL_SMTP_HOST), prop.getProperty(IPropertiesApp.EMAIL_SMTP_PORT),
				prop.getProperty(IPropertiesApp.EMAIL_SMTP_USERNAME), prop.getProperty(IPropertiesApp.EMAIL_SMTP_PASSWORD), false);
	}

	/**
	 * Envoie un mail
	 * 
	 * @param pEmailFrom email From
	 * @param pEmailTo email To
	 * @param pEmailCc email Cc
	 * @param pMessageText message
	 * @param pSubject sujet
	 * @param pHost smptp host
	 * @param pPort smptp port
	 * @param pUsername mail username
	 * @param pPassword mail password
	 * @throws WebbatiException
	 */
	public static void sendMail(String pEmailFrom, String pEmailTo, String pEmailCc, String pMessageText, String pSubject, String pHost,
	        String pPort, final String pUsername, final String pPassword) throws WebbatiException {
		sendMail(pEmailFrom, pEmailTo, pEmailCc, pMessageText, pSubject, pHost, pPort, pUsername, pPassword, false);
	}

	/**
	 * Envoie un mail
	 * 
	 * @param pEmailFrom email From
	 * @param pEmailTo email To
	 * @param pEmailCc email Cc
	 * @param pMessageText message
	 * @param pSubject sujet
	 * @param pSmtpHost smptp host
	 * @param pSmtpPort smptp port
	 * @param pSmtpUsername mail username
	 * @param pSmtpPassword mail password
	 * @param pIsDebug TRUE si on veut voir le debug, FALSE sinon
	 * @throws WebbatiException
	 */
	public static void sendMail(String pEmailFrom, String pEmailTo, String pEmailCc, String pMessageText, String pSubject, String pSmtpHost,
			String pSmtpPort, final String pSmtpUsername, final String pSmtpPassword, boolean pIsDebug) throws WebbatiException {

		// Initialisation
		Properties props = new Properties();
		props.put("mail.smtp.host", pSmtpHost);
		props.put("mail.smtp.port", pSmtpPort);
		Session session = null;

		// Spécificité TLS ou SSL
		if (SMTP_PORT_TLS.equals(pSmtpPort) || SMTP_PORT_SSL.equals(pSmtpPort)) {
			if (SMTP_PORT_TLS.equals(pSmtpPort)) {
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
			} else {
				props.put("mail.smtp.socketFactory.port", SMTP_PORT_SSL);
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			}

			session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(pSmtpUsername, pSmtpPassword);
				}
			});
		} else {
			session = Session.getDefaultInstance(props, null);
		}

		session.setDebug(pIsDebug);
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(pEmailFrom));
			InternetAddress[] internetAddresses = new InternetAddress[1];
			internetAddresses[0] = new InternetAddress(pEmailTo);
			message.setRecipients(Message.RecipientType.TO, internetAddresses);
			if (pEmailCc != null && !pEmailCc.isEmpty()) {
				message.addRecipient(Message.RecipientType.CC, new InternetAddress(pEmailCc));
			}
			message.setSubject(pSubject);
			message.setText(pMessageText);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new WebbatiException("Erreur envoi de mail", e);
		}
	}
}
