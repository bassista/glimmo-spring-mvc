package be.glimmo.util;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestEncrypter {
	@DataProvider(name="invalidPasswordProvider")
	public Object[][] createInvalidPassword(){
		return new Object[][]{
				new Object []{""},
				new Object []{" "},
				new Object []{"\n"},
				new Object []{" \n "},
				new Object []{"\t"},
				new Object []{" \t "},
				new Object []{"\r"},
				new Object []{" \r "},
				new Object[] {"  \n  \t  \r "}
		};
	}
	
	@DataProvider(name="validPasswordProvider")
	public Object[][] createValidPassword(){
		return new Object[][]{
				new Object []{"pouet"},
				new Object []{"test"},
				new Object []{"12345"},
				new Object []{"password"},
				new Object []{"thisisfun"},
				new Object[] {"trololol"}
		};
	}

	/**
	 *  Testing Encrypter behavior when it's passed different invalid password String objects to encrypt
	 */
	@Test(dataProvider="invalidPasswordProvider")
	public void testEncryptionInvalidArgument(String pwd){
		Assert.assertNull(Encrypter.encrypt(pwd));
	}


	/**
	 *  Testing Encrypter behavior when it's passed different valid password String objects to encrypt
	 */
	@Test(dataProvider="validPasswordProvider")
	public void testEncryptionValidArgument(String pwd){
		Assert.assertNotNull(Encrypter.encrypt(pwd));
	}
	
	@Test
	public void testEncryptionResult(){
		Assert.assertEquals(Encrypter.encrypt("secret"), "5ebe2294ecd0e0f08eab7690d2a6ee69");
	}
}
