import javax.crypto.Cipher;
import javax.crypto.SecretKey;


public interface StreamCipher {

    public String encrypt(String plainText, SecretKey key);
    public String decrypt(String str, SecretKey key);
    
}
