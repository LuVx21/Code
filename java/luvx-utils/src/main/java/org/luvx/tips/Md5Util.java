package org.luvx.tips;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import sun.misc.BASE64Encoder;

public class Md5Util {

	
	/*public static String encode(String oldStr){
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte []afterStr = md5.digest(oldStr.getBytes());
			
			BASE64Encoder b64 = new BASE64Encoder();
			return b64.encode(afterStr);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}*/
	
	public static String encode(String oldStr){
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte []afterStr = md5.digest(oldStr.getBytes());
			
			BigInteger bigInt = new BigInteger(1, afterStr);
			return bigInt.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testMd5(){
		System.out.println(Md5Util.encode("1234"));
		
	}
}
