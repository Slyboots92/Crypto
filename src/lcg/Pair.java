package lcg;

public class Pair implements Comparable<Pair>{

	public Pair(Long a,Long b){
		this.a=a;
		this.b=b;
	}
	private Long a;
	private Long b;
	public Long getA() {
		return a;
	}
	public void setA(Long a) {
		this.a = a;
	}
	public Long getB() {
		return b;
	}
	public void setB(Long b) {
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.getA().equals(this.getA())&&o.getB().equals(this.getB()))
			return 0;
		else
			return 1;
	}
}
