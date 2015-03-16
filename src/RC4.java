import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;


public class RC4 {

	 public static String encrypt(String plainText,SecretKey key){
		  String cipher=null;
		    try {
		    	Cipher rc4 = Cipher.getInstance("RC4",new BouncyCastleProvider());
				rc4.init(Cipher.ENCRYPT_MODE, key);
				byte [] cipherText = rc4.update(plainText.getBytes("ASCII"));
				//System.out.println("bytes before "+ Arrays.toString(cipherText));
				cipher=DatatypeConverter.printHexBinary(cipherText);
				//System.out.println("after "+DatatypeConverter.parseHexBinary(cipher));
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		    return cipher;
		    
	}
	 
	public String decrypt(byte [] cipherText,SecretKey key){
		String result = null;
		Cipher rc4Decrypt;
		try {
			rc4Decrypt = Cipher.getInstance("RC4");
			rc4Decrypt.init(Cipher.DECRYPT_MODE, key);
			byte [] clearText2 = rc4Decrypt.update(cipherText);
			result=new String(clearText2, "ASCII");
		} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	   
	    return result;
	}
	
	
	@Test
	public void test(){
		
    	 final String keyStoreFile = "/tmp/keystore.keystore";
	     KeyStore keyStore;
	     String plainText="Attack at dawn";
	     String key="Secret";
	     
	     String cipherText = null;
	     String retriveText = null;
	     SecretKey secretKey;
		try {
			byte [] keyBytes = key.getBytes("ASCII");
			secretKey=new SecretKeySpec(keyBytes, "RC4");
			cipherText=encrypt(plainText, secretKey);
			System.out.println("cipher text = "+cipherText);
			retriveText=decrypt(DatatypeConverter.parseHexBinary(cipherText), secretKey);
			System.out.println("retrive text "+retriveText);
	    	//SecretKey secretKey = KeyGenerator.getInstance("RC4").generateKey();
		     
			keyStore = KeyStorageHelper.createOrLoadKeyStore(keyStoreFile, "passwd2KeyStore");
			KeyStorageHelper.storeSecretKey(secretKey, "password2Key", "passwd2KeyStore", "keyalias", keyStore, keyStoreFile);
			SecretKey foundSecretKey=KeyStorageHelper.retrieveStoredKey(keyStoreFile, "passwd2KeyStore", "keyalias", "password2Key");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    assertEquals("45A01F645FC35B383552544B9BF5", cipherText);
	    assertEquals(plainText, retriveText);
		
	}
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
		
		
	}
	
}
