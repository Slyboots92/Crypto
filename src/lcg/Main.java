package lcg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.collect.Lists;

public class Main {

	public static void main(String[] args) throws Exception {
		
		LCG lcg = new LCG(12, 16807 , 2, (long) (Math.pow(2, 31)-1));
		//LCG lcg = new LCG(12,16849,2,1014356);
		
		//2147483647
		ArrayList<Long> input = new ArrayList<Long>();
		for(int i=0;i<100;i++){
			input.add(lcg.generateNextValue());
		}
		
		System.err.println("test "+input.get(0)+" "+input.get(1)+" "+input.get(2)+" "+input.get(3));
		LCGPredictor predictor = new LCGPredictor();
		Long m=predictor.inputData(input);
		System.out.println("m  "+m);
		
		BrutalForceMaintenance bfMaintenance= new BrutalForceMaintenance();
		bfMaintenance.crackLCGParams(3, input, m);
		
	}
	
	
}
