package lcg;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		
		LCG lcg = new LCG(12, 16807 , 2, (long) (Math.pow(2, 31)-1));
		
		
		//2147483647
		ArrayList<Long> input = new ArrayList<Long>();
		for(int i=0;i<100;i++){
			input.add(lcg.generateNextValue());
		}
		LCGPredictor predictor = new LCGPredictor();
		System.out.println("m  "+predictor.inputData(input));
		
	}

}
