package common.api.test;

import org.junit.Assert;
import org.junit.Test;

import common.api.util.EncodingTools;

public class TestCryptage {

	/*Note null padding*/
	private static String plaintext = "test text 123\0\0\0";
	private static String encryptionKey = "0123456789abcdef";

	@Test
	public void crypter() throws Exception {
		byte[] cipher = EncodingTools.encrypt(plaintext, encryptionKey);
		String texteDecrypted = EncodingTools.decrypt(cipher, encryptionKey);

		Assert.assertTrue(plaintext.equals(texteDecrypted));
	}

	@Test
	public void encoder() throws Exception {
		System.out.println(EncodingTools.encode("bf_admin_WEBBATI_BF_ADMIN", "md5"));
	}

}
