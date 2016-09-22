package common.api.test;

import org.junit.Test;

import common.api.application.impl.PropertiesAppImpl;
import common.api.application.interfaces.IPropertiesApp;
import common.api.exception.BatifreeException;
import common.api.util.Mail;

public class TestMail {

	@Test
	public void sendMail() throws BatifreeException {
		// String emailFrom = "damien.colomies@gmail.com";
		IPropertiesApp prop = new PropertiesAppImpl();
		String emailTo = "kero31@gmail.com";

		// String emailFrom = "batitestadmin@free.fr";
		String emailFrom = prop.getProperty(IPropertiesApp.EMAIL_FROM);
		// String emailTo = "kero31@gmail.com";

		// String emailCc = "elle.himself@wanadoo.fr";
		String messageText = "test Javamail";
		String subject = "Ceci est un test Javamail";

		// String smtpHost = "smtp.free.fr";
		// String smtpPort = "587";
		// String smtpUsername = "batitestadmin@free.fr";
		// String smtpPassword = "batitestadmin";

		String smtpHost = prop.getProperty(IPropertiesApp.EMAIL_SMTP_HOST);
		String smtpPort = prop.getProperty(IPropertiesApp.EMAIL_SMTP_PORT);
		String smtpUsername = prop.getProperty(IPropertiesApp.EMAIL_SMTP_USERNAME);
		String smtpPassword = prop.getProperty(IPropertiesApp.EMAIL_SMTP_PASSWORD);

		boolean debug = true;

		Mail.sendMail(emailFrom, emailTo, null, messageText, subject, smtpHost, smtpPort, smtpUsername, smtpPassword, debug);
	}
}
