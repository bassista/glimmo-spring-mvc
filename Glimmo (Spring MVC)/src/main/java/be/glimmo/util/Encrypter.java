package be.glimmo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * This class provides convenience method(s) to encrypt String objects using a non symmetric algorithm
 * @author Kro
 * @version 03/05/2012
 */
public class Encrypter {
	private static final String ENCRYPTION_ALGO = "MD5";
	
	private static Logger logger = Logger.getLogger(Encrypter.class);
	
	public static String encrypt(String input){
		if(input == null || StringUtils.isEmpty(input) || StringUtils.isBlank(input)){
			logger.warn("Cannot encrypt an invalid password --> returning NULL value");
			return null;
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance(ENCRYPTION_ALGO);
			md.update(input.getBytes());
			return new BigInteger(1,md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			logger.error("error occured when retrieving the specified encryption algorithm [" + ENCRYPTION_ALGO + "]", e);
			return null;
		}
	}
}
