package aes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.junit.Test;



public class KeyStorageHelper {

		
		public static SecretKey loadSecretKeyUsingConfigFile(String pathToConfigFile){
			
			PrivateConfig config=loadSettingFromFile(pathToConfigFile);
			SecretKey secretKey=retrieveStoredKey(config.getKeyStoreLocation(),config.getPasswordToKeyStore(),
					config.getKeyAlias(),config.getPasswordToKey());
			return secretKey;
		}
	  	private static PrivateConfig loadSettingFromFile(String path){
	  		File configFile= new File(path);
	  		PrivateConfig result;
	  		ArrayList<String> configs= new ArrayList<String>();
	  		if(!configFile.exists()){
	  			throw new NullPointerException();
	  		}
	  		else{
	  			try {
					Scanner scanner = new Scanner(configFile);
					while(scanner.hasNextLine()){
						configs.add(scanner.nextLine());
					}
					scanner.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	  			result = new PrivateConfig();
	  			result.setKeyStoreLocation(configs.get(0));
	  			result.setPasswordToKeyStore(configs.get(1));
	  			result.setKeyAlias(configs.get(2));
	  			result.setPasswordToKey(configs.get(3));
	  		}
			return result;
	  		
	  	}
	    public static SecretKey retrieveStoredKey(String keyStoreFile,String keyStorePassword,String alias,String keyPasswd){
	    	
	    
	    	SecretKey keyFound = null ;
			try {
				KeyStore keyStore = createOrLoadKeyStore(keyStoreFile,keyStorePassword);
				 PasswordProtection keyPassword = new PasswordProtection(keyPasswd.toCharArray());
		         KeyStore.Entry entry = keyStore.getEntry(alias, keyPassword);
			     keyFound = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
		     return keyFound;
	    }
	    public static void storeSecretKey(SecretKey secretKey,String password2Key,String password2KeyStore,
	    		String alias,KeyStore keyStore,String keyStorePath){
	    	
	    	
	    	 	KeyStore.SecretKeyEntry keyStoreEntry = new KeyStore.SecretKeyEntry(secretKey);
		        PasswordProtection keyPassword = new PasswordProtection(password2Key.toCharArray());
		        try {
					keyStore.setEntry(alias, keyStoreEntry, keyPassword);
					  keyStore.store(new FileOutputStream(keyStorePath), password2KeyStore.toCharArray());
				} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
					e.printStackTrace();
				}
		      
	    }
	   public static String base64String(SecretKey secretKey) {
	        return new String(Base64.getEncoder().encode(secretKey.getEncoded()));
	    }

	    public static KeyStore createOrLoadKeyStore(String fileName, String pw) throws Exception {
	        File file = new File(fileName);

	        final KeyStore keyStore = KeyStore.getInstance("JCEKS");
	        if (file.exists()) {
	            // .keystore file already exists => load it
	            keyStore.load(new FileInputStream(file), pw.toCharArray());
	            System.out.println("Existing .keystore file loaded!");
	        } else {
	            // .keystore file not created yet => create it
	            keyStore.load(null, null);
	            keyStore.store(new FileOutputStream(fileName), pw.toCharArray());
	            System.out.println("New .keystore file created!");
	        }

	        return keyStore;
	    }
	    
	    
	    @Test
	    public  void testKeyStorage(){
		     String key_input = null;
		     String key_output = null;
	    	 final String keyStoreFile = "/tmp/keystore.keystore";
		     KeyStore keyStore;
			try {

		    	 SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
		    	 key_input=base64String(secretKey);
			     System.out.println("Stored Key:\t" + key_input);
			     
				keyStore = createOrLoadKeyStore(keyStoreFile, "passwd2KeyStore");
				storeSecretKey(secretKey, "password2Key", "passwd2KeyStore", "keyalias", keyStore, keyStoreFile);
				SecretKey foundSecretKey=retrieveStoredKey(keyStoreFile, "passwd2KeyStore", "keyalias", "password2Key");
				key_output=base64String(foundSecretKey);
			    System.out.println("Found Key: " + key_output);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertNotEquals(null, key_input);
			assertNotEquals(null, key_output);
		    assertEquals(key_input, key_output);
	    	
	    	
	    }
	

}
