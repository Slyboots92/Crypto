package lab1;
import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;


public class SALSA20 {

	 public  String encrypt(String plainText,SecretKey key,IvParameterSpec ivspec ){
		  String cipher=null;
		    try {
		    	Cipher aes = Cipher.getInstance("SALSA20");
		    	aes.init(Cipher.ENCRYPT_MODE, key,ivspec);
				byte [] cipherText = aes.update(plainText.getBytes("ASCII"));
				cipher=DatatypeConverter.printHexBinary(cipherText);
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			}
		    return cipher;
		    
	}
	 
	public  String decrypt(byte [] cipherText,SecretKey key,IvParameterSpec ivspec ){
		String result = null;
		Cipher aes;
		try {
			aes = Cipher.getInstance("SALSA20");
	    	
	    	aes.init(Cipher.DECRYPT_MODE, key,ivspec);
			byte [] clearText2 = aes.update(cipherText);
			result=new String(clearText2, "ASCII");
		} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException | NoSuchPaddingException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}
	   
	    return result;
	}
	
	
	@Test
	public void test(){
		
		
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	     String plainText="Attack at dawn";
	     byte[] iv = { 0, 0, 0, 0, 0, 0, 0,0};
	    IvParameterSpec ivspec = new IvParameterSpec(iv);
	     KeyGenerator kgenerator = null;
	     SecretKey secretKey = null;
	     String cipherText = null;
	     String retriveText = null;
		try {
			SecureRandom random = new SecureRandom();
			kgenerator=KeyGenerator.getInstance("SALSA20");
			kgenerator.init(192, random);
			secretKey = KeyGenerator.getInstance("SALSA20").generateKey();
			System.out.println(secretKey.getEncoded().length);
	
			cipherText=encrypt(plainText, secretKey,ivspec);
			System.out.println("cipher text = "+cipherText);
			retriveText=decrypt(DatatypeConverter.parseHexBinary(cipherText), secretKey,ivspec);
			System.out.println("retrive text "+retriveText);
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(plainText, retriveText);
	}
	
	
}
