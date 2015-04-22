package lcg;

public class LCG {

	public LCG(long x0,long a,long b,long m){
		this.x0=x0;
		this.a=a;
		this.b=b;
		this.m=m;
		this.actualValue=x0;
		
	}
	private long x0;
	private long a;
	private long b;
	private long m;
	private long actualValue;
	
	public long  generateNextValue(){
		
		this.actualValue=(a*actualValue+b)%m; 
		return actualValue;
	}
}
