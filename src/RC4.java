import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class RC4 {

	 public String encrypt(String plainText,SecretKey key){
		  String cipher=null;
		    try {
		    	Cipher rc4 = Cipher.getInstance("RC4",new BouncyCastleProvider());
				rc4.init(Cipher.ENCRYPT_MODE, key);
				byte [] cipherText = rc4.update(plainText.getBytes("ASCII"));
				cipher=DatatypeConverter.printHexBinary(cipherText);
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
			//System.out.println("decrypted (clear) is " + new String(clearText2, "ASCII"));
		} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	   
	    return result;
	}
	
	
	
}
