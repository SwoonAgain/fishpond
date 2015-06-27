package fishpond.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {
	
	private static URL fishpondProp;
	
	static{
		fishpondProp = PropertiesUtil.class.getClassLoader().getResource("/fishpond.properties");
	}
	
	private PropertiesUtil(){}
	
	/**
	 * @param key
	 * @return null if not found
	 */
	public static final String get(String key){
		Properties prop = new Properties();
		InputStream inStream = null;
		String result = null;
		try {
			inStream = new FileInputStream(fishpondProp.getFile());
			prop.load(inStream);
			result = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
