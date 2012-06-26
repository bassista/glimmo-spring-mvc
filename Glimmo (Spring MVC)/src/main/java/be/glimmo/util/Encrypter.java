package be.glimmo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * This class provides convenience method(s) to encrypt String objects using the MD5 non symmetric algorithm
 * @author Kro
 * @version 03/05/2012
 */
public class Encrypter {
	
	private static Logger logger = Logger.getLogger(Encrypter.class);
	
	public static String encrypt(String input){
		if(input == null || StringUtils.isEmpty(input) || StringUtils.isBlank(input)){
			logger.warn("Cannot encrypt an invalid password --> returning NULL value");
			return null;
		}
		
		return new Md5PasswordEncoder().encodePassword(input, null);
	}
}
