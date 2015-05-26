package lcg;

import java.util.ArrayList;

public class EquationSolver {

	public static ArrayList<Pair> solveEquations(Long c1,Long a1,Long c2,Long a2,Long n){
		
		Long a;
		Long b;
		if(a2>a1){
			a=a2-a1;
			b=c2-c1;
		}
		else{
			a=a1-a2;
			b=c1-c2;
		}
		Long aRes = solvingLinearEqu(a,b,n);
		Long bShiift = computeBShifft(c2,c1,aRes,n);
		System.out.println("a "+aRes+" b "+bShiift);
		Pair pair = new Pair();
		pair.setA(aRes);
		pair.setB(bShiift);
		ArrayList<Pair> result = new ArrayList<Pair>();
		result.add(pair);
		return result;
		
	}
	private static Long[] gcd(Long p, Long q) {
	      if (q == 0)
	         return new Long[] { p, 1l, 0l };

	      Long[] vals = gcd(q, p % q);
	      Long d = vals[0];
	      Long a = vals[2];
	      Long b = vals[1] - (p / q) * vals[2];
	      return new Long[] { d, a, b };
	 }
	private static Long computeBShifft(Long c,Long a,Long x,Long n){
		
		System.out.println("c-ax "+c+" "+a+" x"+x );
		Long result =c-a*x;
		while(result<0){
			result=result+n;
		}
		return result;
	}
	 public static Long solvingLinearEqu(Long a,Long b,Long n){
		 Long z,y,d;

		 Long[] eea = gcd(a,n);
		    d=eea[0];
		    z=eea[2];
		    y=eea[1];

		    Long result = (b*y)%n;
		    while(result<0){
		    	result=result+n;
		    }
		    System.out.println("nwd(a,n) = "+d+" = ya + zn "+y+ " "+a+" "+z+" "+n);
		    System.out.println(" sol x0 +kn"+result);
		    return (long) result;
	 }
}
