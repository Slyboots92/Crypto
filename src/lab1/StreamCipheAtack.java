package lab1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;



public class StreamCipheAtack {
	
		public static Map<Integer, Byte>  matching(ArrayList<Byte[]> ciphers){
			Map<Integer,ArrayList<Byte>> key = new TreeMap<Integer,ArrayList<Byte>>();
			for(int i=0;i<ciphers.size();i++){
				for(int j=i+1;j<ciphers.size();j++){
					Byte[] c1=ciphers.get(i);
					Byte[] c2=ciphers.get(j);
					findSpaces(c1,c2,key);
				}
				
			}
			Map<Integer, Byte> keyBestMatched = getKeyCandidate(ciphers, key);
			return keyBestMatched;
		}
		public static Map<Integer,Byte> getKeyCandidate(ArrayList<Byte[]> ciphers,Map<Integer,ArrayList<Byte>> key){
			
			Map<Integer,Byte> result =new TreeMap<Integer,Byte>();
			Set<Integer> ids = key.keySet();
			for (Integer id : ids) {
				ArrayList<Byte> keyCandidates = key.get(id);
				result.put(id, findBestMatchingKey(ciphers,id,keyCandidates));
			}
			return result;
			
		}
		
		private static byte findBestMatchingKey(ArrayList<Byte[]> ciphers,Integer position,ArrayList<Byte> keys){
			
			int matchedValues;
			int maxValue=0;
			Byte keyBestMatched = null;
			System.out.println("position "+position);
			System.out.println("_________________________");
			for (Byte key : keys) {
				matchedValues=0;
				for (Byte[] cipher : ciphers) {
					if(cipher.length>position){
						byte message=(byte) (cipher[position]^key);
						if((message>=64&&message<=90)||(message>=97&&message<=122)){
							matchedValues++;
							}
						}
					if(matchedValues>=maxValue){
						maxValue=matchedValues;
						keyBestMatched=key;
						}
					}
					
				}
			System.out.println(" choosen "+keyBestMatched);
			return keyBestMatched;
		}
		public static void findSpaces(Byte[] c1,Byte[]c2,Map<Integer,ArrayList<Byte>> key){
	
			int size;
			if(c1.length<c2.length)
				size=c1.length;
			else
				size=c2.length;
			for (int i=0;i<size;i++) {
				byte result=(byte) (c1[i]^c2[i]);
				if(result>=64&&result<=90||result>=97&&result<=122){
					//System.out.println(i+" "+result);
					byte m=(byte) (result^32);
					//System.out.println(m);
					if(key.get(i)==null){
						ArrayList<Byte> res= new ArrayList<Byte>();
						key.put(i, res);
					}
					
					key.get(i).add((byte) (m^c1[i]));
					key.get(i).add((byte) (m^c2[i]));
					
				}
			}
		}
	
	public static void main(String[] args) throws IOException {
		/*RC4 rc4= new RC4();
		String [] array= new String [16];
		String basePath="/home/slyboots/development/workspace/eclipse_workspace/Crypto/";
		array[0]="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen "; 
 		array[1]="remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		array[2]="It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'C";
		array[3]="editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected ";
		array[4]="Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia,"; 
		array[5]="undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum(The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Re";
		array[6]="There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of ";  
		array[7]="Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to gen";		
	
	   String key="Secret";
		SecretKey secretKey;
		byte [] keyBytes = key.getBytes("ASCII");
		secretKey=new SecretKeySpec(keyBytes, "RC4");
		
		ArrayList<Byte[]> ciphers= new ArrayList<Byte[]>();
		for (String plainText : array) {
			String cipher=rc4.encrypt(plainText, secretKey);
			byte[] cipherBytes=DatatypeConverter.parseHexBinary(cipher);
			Byte [] bigByte= new Byte[cipherBytes.length];
			for (int i=0;i<cipherBytes.length;i++) {
				bigByte[i]= new Byte(cipherBytes[i]);
			}
			ciphers.add(bigByte);
		}
		Map<Integer, Byte> keyCandidate=matching(ciphers);
		
		
		byte [] cracked = new byte[ciphers.get(0).length];
		Set<Integer> ids = keyCandidate.keySet();
		
		for (int i=0;i<cracked.length;i++) {
			cracked[i]=32;
		}
		for (Integer integer : ids) {
			System.out.println("integer "+integer);
			cracked[integer]= (byte) (keyCandidate.get(integer)^ciphers.get(8)[integer]);
			System.out.println("cracked[integer] "+cracked[integer]);
		}
		String crackedString=new String(cracked, "ASCII");
		System.out.println("size "+crackedString.length());
	System.out.println("crackedString"+crackedString);*/
		/*for (int i=0; i<array.length ;i++) {
			String cipher=encrypt(array[i], secretKey);
			byte[] b=DatatypeConverter.parseHexBinary(cipher);
			String result = "";
			for (byte c : b) {
				result+=Integer.toBinaryString(c)+" ";
			}
			System.out.println(result);
			FileOutputStream out= new FileOutputStream(new File(basePath+"t"+(i+1)));
		}*/
		//System.out.println(b0[5]);
		//System.out.println(DatatypeConverter.parseHexBinary(c0)^DatatypeConverter.parseHexBinary(c1));
		//encrypt(plainText, secretKey);
		
		ArrayList<Byte[]> ciphers= new ArrayList<Byte[]>();
		String path="/home/slyboots/development/workspace/eclipse_workspace/Crypto/c";
		for(int i=1;i<=17;i++){
			File file = new File(path+i);
			FileInputStream in = new FileInputStream(file);
			BufferedReader reader = new BufferedReader( new FileReader (file));
		    String         line = null;
		    while( (line=reader.readLine())!=null){
			    String lineArray[]=line.split(" ");
			    Byte[] cipher= new Byte[lineArray.length];
			    for (int j=0; j<lineArray.length; j++) {
					cipher[j]=(byte) Integer.parseInt(lineArray[j],2);
				}
			    ciphers.add(cipher);
		    }
		}
		Map<Integer, Byte> keyCandidate=matching(ciphers);
		
		
		byte [] cracked = new byte[ciphers.get(10).length];
		Set<Integer> ids = keyCandidate.keySet();
		
		for (int i=0;i<cracked.length;i++) {
			cracked[i]=32;
		}
		for (Integer integer : ids) {
			System.out.println("integer "+integer);
			if(integer<ciphers.get(16).length&&keyCandidate.size()>integer){
				cracked[integer]= (byte) (keyCandidate.get(integer)^ciphers.get(16)[integer]);
				System.out.println("cracked[integer] "+cracked[integer]);
			}
	
		}
		String crackedString=new String(cracked, "ASCII");
		System.out.println("size "+crackedString.length());
	    System.out.println(crackedString);
	    
	    
	}
}
		 
		
