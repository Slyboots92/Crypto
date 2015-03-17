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
		String [] array= new String [8];
		String basePath="/home/slyboots/development/workspace/eclipse_workspace/Crypto/";
		array[0]="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting";
		array[1]="remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		array[2]="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page";
		array[3]="editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";
		array[4]="Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the";
		array[5]="undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum(The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.";
		array[6]="There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem";
		array[7]="Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.";
		String key="Secret";
		SecretKey secretKey;
		byte [] keyBytes = key.getBytes("ASCII");
		secretKey=new SecretKeySpec(keyBytes, "RC4");
		
		//String cipher=encrypt(array[0], secretKey);
		//byte[] b=cipher.getBytes("ASCII");
	
		
		
		
	for (int i=0; i<array.length ;i++) {
			String cipher=encrypt(array[i], secretKey);
			byte[] b=DatatypeConverter.parseHexBinary(cipher);
			String result = "";
			for (byte c : b) {
				result+=Integer.toBinaryString(c)+" ";
			}
			System.out.println(result);
			FileOutputStream out= new FileOutputStream(new File(basePath+"t"+(i+1)));
		}
		//System.out.println(b0[5]);
		//System.out.println(DatatypeConverter.parseHexBinary(c0)^DatatypeConverter.parseHexBinary(c1));
		//encrypt(plainText, secretKey);
		
		
		
	}
	
}
