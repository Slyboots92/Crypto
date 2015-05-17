package aes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class UserInputMaintenance {

	private static final String configPath="/home/slyboots/development/workspace/eclipse_workspace/Crypto/resource/config";
	public void maintenance(){
		
		byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	    IvParameterSpec ivspec = new IvParameterSpec(iv);
		SecretKey secretKey = KeyStorageHelper.loadSecretKeyUsingConfigFile(configPath);
		
		String buff;
		int encdec;
		int modeChoice;
		int eventMode;
		String pathToFile;
		Scanner scanner =new  Scanner(System.in);
		System.out.println("1 - to encrypt");
		System.out.println("2 - to decrypt");
		encdec = Integer.parseInt(scanner.nextLine());
		System.out.println("path to file");
		pathToFile=scanner.nextLine();
		System.out.println("1 - OFB");
		System.out.println("2 - CTR");
		System.out.println("3 - CBC");
		modeChoice=Integer.parseInt(scanner.nextLine());
		System.out.println("1- encryption oracle");
		System.out.println("2- challange");
		eventMode=Integer.parseInt(scanner.nextLine());
		
		ArrayList<String> loadedFile = FileMaintenance.loadContentList(pathToFile);
		
		if(eventMode==1){//oracle
			
			if(encdec==1){//enc
				
				switch(modeChoice){
				
				case 1: for (String string : loadedFile) {
					System.out.println(AES_OFB.encrypt(string, secretKey, ivspec));
				}
						break;
				case 2:for (String string : loadedFile) {
					System.out.println(AES_CTR.encrypt(string, secretKey, ivspec));
				}
						break;
				case 3:for (String string : loadedFile) {
					System.out.println(AES_CBC.encrypt(string, secretKey, ivspec));
				}
						break;
				default:
					System.out.println("zly wybor");
				}
			}
			else if(encdec==2){//dec
			
				switch(modeChoice){
				
				case 1: for (String string : loadedFile) {
					System.out.println(AES_OFB.decrypt(DatatypeConverter.parseHexBinary(string), secretKey, ivspec));
				}
						break;
				case 2:for (String string : loadedFile) {
					System.out.println(AES_CTR.decrypt(DatatypeConverter.parseHexBinary(string), secretKey, ivspec));
				}
						break;
				case 3:for (String string : loadedFile) {
					System.out.println(AES_CBC.decrypt(DatatypeConverter.parseHexBinary(string), secretKey, ivspec));
				}
						break;
				default:
					System.out.println("zly wybor");
				}

			}
		}
		else if(eventMode==2){
			
			String m0=loadedFile.get(0);
			String m1=loadedFile.get(1);
			
			String toEncrypt;
			Random rand = new Random();
			if(rand.nextInt()%2==0){
				toEncrypt=m0;
			}
			else{
				toEncrypt=m1;
			}
			switch(modeChoice){
			
			case 1:	System.out.println(AES_OFB.encrypt(toEncrypt, secretKey, ivspec));
					break;
			case 2: 
				System.out.println(AES_CTR.encrypt(toEncrypt, secretKey, ivspec));
					break;
			case 3:
				System.out.println(AES_CBC.encrypt(toEncrypt, secretKey, ivspec));
					break;
			default:
				System.out.println("zly wybor");
			}
		}
		

	}
}
