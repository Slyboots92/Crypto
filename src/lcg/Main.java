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
		
		//LCG lcg = new LCG(12, 16807 , 2, (long) (Math.pow(2, 31)-1));
		LCG lcg = new LCG(12,16807,2,101);
		
		//2147483647
		ArrayList<Long> input = new ArrayList<Long>();
		for(int i=0;i<100;i++){
			input.add(lcg.generateNextValue());
		}
		LCGPredictor predictor = new LCGPredictor();
		System.out.println("m  "+predictor.inputData(input));
		ArrayList<BrutalForceThread> threads= new ArrayList<BrutalForceThread>();
		CopyOnWriteArrayList<Pair> result1= new CopyOnWriteArrayList<Pair>();
		CopyOnWriteArrayList<Pair> result2= new CopyOnWriteArrayList<Pair>();
		CopyOnWriteArrayList<Pair> result3= new CopyOnWriteArrayList<Pair>();
		
		result3.add(new Pair(2L, 2L));
		result3.add(new Pair(2L, 2L));
		
		result2.add(new Pair(2L, 2L));
		result2.add(new Pair(3L, 3L));
		
		result2.removeAll(result3);
		for (Pair pair : result2) {
			System.out.println(" test "+pair.getA()+" "+pair.getB());
		}
		System.out.println("freqqq "+Collections.frequency(result3, result3.get(0)));
		
		threads.add(new BrutalForceThread(1, 101L,
				input.get(0), input.get(1), result1));
		threads.add(new BrutalForceThread(2, 101L,
				input.get(1), input.get(2), result1));
		threads.add(new BrutalForceThread(3, 101L,
				input.get(2), input.get(3), result1));
		for(int i=0;i<3;i++){
			threads.get(i).start();
		}
		
		while(threads.get(0).isFlag()||threads.get(1).isFlag()||
				threads.get(2).isFlag()){
			Thread.sleep(2000);
			System.out.println("size "+result1.size());
		/*	for(int i=0;i<result1.size();i++){
				
				System.out.println("a b "+result1.get(i).getA()+" "+result1.get(i).getB()+
				" freq "+Collections.frequency(result1, result1.get(i)));
			}*/
			
		}
		
	}
	private Map<Pair,int > mapIt(CopyOnWriteArrayList<Pair> input){
		
		Map<Pair,Integer> result = new TreeMap<Pair,Integer>();
		for(int i=0;i<input.size();i++){
			
			
		}
		
	}
}
