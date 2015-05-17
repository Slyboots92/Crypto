package aes;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class AES_CBC {

	
	
	 public  static String encrypt(String plainText,SecretKey key,IvParameterSpec ivspec ){
		  String cipher=null;
		    try {
		    	Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    	aes.init(Cipher.ENCRYPT_MODE, key,ivspec);
		    	 byte[] cipherText = aes.doFinal(plainText.getBytes("ASCII"));
				//byte [] cipherText = aes.update();
				cipher=DatatypeConverter.printHexBinary(cipherText);
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
				e.printStackTrace();
			}
		    return cipher;
		    
	}
	 public  static String decrypt(byte [] cipherText,SecretKey key,IvParameterSpec ivspec ){
			String result = null;
			Cipher aes;
			try {
				aes = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    	
		    	aes.init(Cipher.DECRYPT_MODE, key,ivspec);
		    	byte [] clearText2=aes.doFinal(cipherText);
				result=new String(clearText2, "ASCII");
			} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
				e.printStackTrace();
			}
		   
		    return result;
		}
	 @Test
		public void test(){
			
		//public static void main(String[] args) {
			
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		     String plainText="Attack at dawn";
		     byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		    IvParameterSpec ivspec = new IvParameterSpec(iv);
		     KeyGenerator kgenerator = null;
		     SecretKey secretKey = null;
		     String cipherText = null;
		     String retriveText = null;
			try {
				SecureRandom random = new SecureRandom();
				kgenerator=KeyGenerator.getInstance("AES");
				kgenerator.init(192, random);
				secretKey = KeyGenerator.getInstance("AES").generateKey();
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
