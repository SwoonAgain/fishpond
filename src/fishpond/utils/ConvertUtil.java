package fishpond.utils;

public class ConvertUtil {

	protected final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static String bytesToHexString(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	/**
	 * 长度不足前面补0，超过丢弃后面位
	 * @param bytes
	 * @param length
	 * @return
	 */
	public static String fixedLengthBytesToHexString(byte[] bytes,int length) {
		StringBuilder sb = new StringBuilder();
	    String tempStr = bytesToHexString(bytes);
	    int tempStrLength = tempStr.length();
	    if (tempStrLength < length) {
			
			for (int i = 0; i < length - tempStrLength ; i++) {
				sb.append("0");
			}
			sb.append(tempStr);
			return sb.toString();
		}else if (tempStrLength == length) {
			return tempStr;
		}else{
			return tempStr.substring(0, length);
		}
	}
	
	public static String byteToHexString(byte b) {
		return String.format("%02X", b) ;
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
}
