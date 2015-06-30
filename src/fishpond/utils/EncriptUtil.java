package fishpond.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptUtil {
	
	private static final String SALT = "fishpondByZXXQ";

	public static String MD5(String source) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			source = SALT + source;
			byte[] resultBytes = digest.digest(source.getBytes("utf-8"));
			String result = ConvertUtil.bytesToHex(resultBytes);
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String result = MD5("admin");
		System.out.println(result);
	}
}
