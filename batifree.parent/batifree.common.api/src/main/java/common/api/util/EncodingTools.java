package common.api.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import common.api.exception.BatifreeException;

/**
 * 
 * Classe/Interface <EncodingTools>
 *
 */
public class EncodingTools {

	private static final int PASSWORD_LENGTH = 6;
	private static final int USERNAME_LENGTH = 10;
	public static final String ENCODING_MD2 = "md2";
	public static final String ENCODING_MD5 = "md5";
	public static final String ENCODING_SHA_1 = "SHA-1";
	public static final String ENCODING_SHA_256 = "SHA-256";
	public static final String ENCODING_SHA_384 = "SHA-384";
	public static final String ENCODING_SHA_512 = "SHA-512";

	public static final String ENCODING_KEY = "BATIFREE";

	private static String IV = "AAAAAAAAAAAAAAAA";

	/**
	 * 
	 * Constructeur.
	 */
	protected EncodingTools() {
		super();
	}

	/**
	 * Encrypter le texte
	 * 
	 * @param pPlainText texte à crypter
	 * @param pEncryptionKey encryptionKey
	 * @return texte cryptée
	 */
	public static byte[] encrypt(String pPlainText, String pEncryptionKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(pEncryptionKey.getBytes("UTF-8"), "AES");
		cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return cipher.doFinal(pPlainText.getBytes("UTF-8"));
	}

	/**
	 * Décrypter le texte
	 * 
	 * @param pCipherText texte à décrypter
	 * @param pEncryptionKey encryptionKey
	 * @return texte décryptée
	 */
	public static String decrypt(byte[] pCipherText, String pEncryptionKey) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
		SecretKeySpec key = new SecretKeySpec(pEncryptionKey.getBytes("UTF-8"), "AES");
		cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
		return new String(cipher.doFinal(pCipherText), "UTF-8");
	}

	/**
	 * Génère une chaine aléatoire d'une longueur précise et avec des caractères compris dans la liste des caractères.
	 * 
	 * @param pLongueur longueur de la chaine
	 * @param pChars caractères possible
	 * @param pPuissance puissance de calcul pour générer la chaine
	 * @return chaine générée
	 */
	private static String generateString(int pLongueur, String pChars, int pPuissance) {
		String pass = "";
		for (int x = 0; x < pLongueur; x++) {
			int i = (int) Math.floor(Math.random() * pPuissance);
			pass += pChars.charAt(i);
		}
		return pass;
	}

	/**
	 * Génère une chaine aléatoire d'une longueur précise
	 * 
	 * @param pLongueur longueur de la chaine
	 * @return chaine généré
	 */
	public static String generateString(int pLongueur) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		// Si tu supprimes des lettres tu diminues ce nb de puissance
		return generateString(pLongueur, chars, 62);
	}

	/**
	 * Génère une chaine alétoire
	 * 
	 * @return chaine généré
	 */
	public static String generateUsername() {
		return generateString(USERNAME_LENGTH);
	}

	/**
	 * Génère une chaine aléatoire pour le Username d'une longueur précise
	 * 
	 * @param pLongueur longueur de la chaine
	 * @return chaine généré
	 */
	public static String generateUsername(int pLongueur) {
		return generateString(pLongueur);
	}

	/**
	 * Génère un mot de passe alétoire
	 * 
	 * @return mot de passe généré
	 */
	public static String generatePassword() {
		return generateString(PASSWORD_LENGTH);
	}

	/**
	 * Génère un mot de passe alétoire
	 * 
	 * @param pLongueur longueur de la chaine
	 * @return mot de passe généré
	 */
	public static String generatePassword(int pLongueur) {
		return generateString(pLongueur);
	}

	/**
	 * Encode un texte avec un algorithm défini
	 * 
	 * @param pTexte mot de passe
	 * @param pAlgorithm algorithm d'encodage (MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512)
	 * @return password encodé
	 * @throws NoSuchAlgorithmException
	 */
	public static String encode(String pTexte, String pAlgorithm) throws BatifreeException {
		byte[] hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance(pAlgorithm);
			hash = md.digest(pTexte.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new BatifreeException("Erreur encodage", e);
		}
		StringBuilder sb = new StringBuilder();
		for (byte element : hash) {
			String hex = Integer.toHexString(element);
			if (hex.length() == 1) {
				sb.append(0);
				sb.append(hex.charAt(hex.length() - 1));
			} else {
				sb.append(hex.substring(hex.length() - 2));
			}
		}
		return sb.toString();
	}
}
