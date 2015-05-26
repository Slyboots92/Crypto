package merkle_hellman;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class MHMaintenance 
{


	@Test
	public void test()
	{
		String message = "Test ";
		long keyLength=(long) message.length();
		keyLength*=8;
		MHGenerator gen = new MHGenerator(keyLength);
		gen.generateKey();
		MHEncryption enc = 
				new MHEncryption(keyLength,
						gen.getPublicKey());
		MHDecryption dec = 
				new MHDecryption(keyLength,
						gen.getPrivateKey(),
						gen.getQ(), gen.getR());
		System.out.println("plaintext "+message);
		BigInteger cipherText=enc.encryptMessage(message);
		System.out.println("cipher text "+cipherText);
		String receivedText=dec.decryptMessage(cipherText);
		System.out.println("retrive text "+receivedText);
		
		if(message.equals(receivedText)){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
		assertEquals(message, receivedText);
		
	}

	

}