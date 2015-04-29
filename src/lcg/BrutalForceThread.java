package lcg;


public class BrutalForceThread extends Thread{
	
	private Long sn;
	private Long sn1;
	private Long sn2;
	private Long sn3;
	private Long m;
	private Long beg;
	private Long end;
	private int threadId;
	public BrutalForceThread(int threadId,Long sn,Long sn1,Long sn2,Long sn3,Long m, Long beg, Long end){
		this.sn=sn;
		this.sn1=sn1;
		this.sn2=sn2;
		this.sn3=sn3;
		this.m=m;
		this.beg=beg;
		this.end=end;
		this.threadId=threadId;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<=m.intValue();i++){
			for(int j=0;j<=m.intValue();j++){
				
				if(sn1.intValue()==((i*sn.intValue()+j)%m)){
					if(checkIsThisPairIsCorrect(i,j,sn3,sn2,sn1)){
						System.err.println("Rozwiazanie a "+i+" b "+j);
					}
				}
			}
		}
	}
	private boolean  checkIsThisPairIsCorrect(int a,int b,Long sn3,Long sn2,Long sn1){

		if(sn3.equals((a*sn2+b)%m)&&sn2.equals((sn1*a+b)%m)){
			
			return true;
		}
		else
			return false;
	}
	public Long getSn() {
		return sn;
	}

	public void setSn(Long sn) {
		this.sn = sn;
	}

	public Long getSn1() {
		return sn1;
	}

	public void setSn1(Long sn1) {
		this.sn1 = sn1;
	}

	public Long getSn2() {
		return sn2;
	}

	public void setSn2(Long sn2) {
		this.sn2 = sn2;
	}

	public Long getSn3() {
		return sn3;
	}

	public void setSn3(Long sn3) {
		this.sn3 = sn3;
	}

	public Long getM() {
		return m;
	}

	public void setM(Long m) {
		this.m = m;
	}

	public Long getBeg() {
		return beg;
	}

	public void setBeg(Long beg) {
		this.beg = beg;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

}
