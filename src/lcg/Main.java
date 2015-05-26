package lcg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//LCG lcg = new LCG(12, 16807 , 2, (long) (Math.pow(2, 31)-1));
		LCG lcg = new LCG(12,57,4,(long) (Math.pow(2, 31)-1));
		
		//2147483647
		ArrayList<Long> input = new ArrayList<Long>();
		for(int i=0;i<100;i++){
			input.add(lcg.generateNextValue());
		}
		
		System.err.println("test "+input.get(0)+" "+input.get(1)+" "+input.get(2)+" "+input.get(3));
		LCGPredictor predictor = new LCGPredictor();
		Long m=predictor.inputData(input);
		System.out.println("m  "+m);
		Long c2=input.get(3);
		Long c1=input.get(2);
		Long a2=input.get(2);
		Long a1=input.get(1);
		EquationSolver.solveEquations(c1, a1, c2, a2, m);
	      
	}
	@Test
	public void test() throws Exception{
		//LCG lcg = new LCG(12, 16807 , 2, (long) (Math.pow(2, 31)-1));
		
				Long m =(long) (Math.pow(2, 31)-1);
				Long a=57l;
				Long b=4l;
				LCG lcg = new LCG(12,a,b,m);
				
				//2147483647
				ArrayList<Long> input = new ArrayList<Long>();
				for(int i=0;i<100;i++){
					input.add(lcg.generateNextValue());
				}
				
				System.err.println("test "+input.get(0)+" "+input.get(1)+" "+input.get(2)+" "+input.get(3));
				LCGPredictor predictor = new LCGPredictor();
				Long mRes=predictor.inputData(input);
				System.out.println("m  "+m);
				Long c2=input.get(3);
				Long c1=input.get(2);
				Long a2=input.get(2);
				Long a1=input.get(1);
				ArrayList<Pair> eqSolve = EquationSolver.solveEquations(c1, a1, c2, a2, m);
				Assert.assertEquals(m, mRes);
				Assert.assertEquals(a, eqSolve.get(0).getA());
				Assert.assertEquals(b, eqSolve.get(0).getB());
	}
	
	
}
