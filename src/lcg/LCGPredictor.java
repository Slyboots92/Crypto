package lcg;

import java.math.BigInteger;
import java.util.ArrayList;

public class LCGPredictor {

	
	
	public Long inputData(ArrayList<Long> input) throws Exception{
		
		ArrayList<Long> result = new ArrayList<Long>();
		if(input.size()>=4){
			for(int i=3;i<input.size();i++){
				result.add(computeMultiple(input.get(i-3),input.get(i-2),input.get(i-1),input.get(i)));
			}
		}
		
		return tryHitM(result);
	}
	public Long computeMultiple(Long a1,Long a2,Long a3,Long a4){
		
		Long tn=a2-a1;
		Long tn1=a3-a2;
		Long tn2=a4-a3;
		return Math.abs(tn2*tn-(tn1*tn1));
		
	}
	
	
	public Long computeGCD(Long a,Long b){
		
		
		BigInteger aBig= new BigInteger(a.toString());
		BigInteger bBig= new BigInteger(b.toString());
		BigInteger result=aBig.gcd(bBig);
		return result.longValueExact();
	}
	public Long tryHitM(ArrayList<Long> list) throws Exception{
		
			Long currentGCD;
			
			if(list.size()>=2){
				
				currentGCD=computeGCD(list.get(0), list.get(1));
				for(int i=2;i<list.size();i++){
					currentGCD=computeGCD(list.get(i), currentGCD);
				}
				return currentGCD;
			}
			else{
				throw new Exception();
				
			}
		
	}
	
}
