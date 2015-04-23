package lcg;

import java.util.concurrent.CopyOnWriteArrayList;

public class BrutalForceThread extends Thread{
	
	private Long m;
	private boolean flag;
	private Long sn;
	private CopyOnWriteArrayList<Pair> result;
	private int number;
	private Long sn1;
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public BrutalForceThread(int number , Long m,Long sn,Long sn1,
			CopyOnWriteArrayList<Pair>result){
		this.m=m;
		this.sn=sn;
		this.sn1=sn1;
		this.result=result;
		this.flag=true;
		this.number=number;
	}
	
	@Override
	public void run() {
		for(Long i=0L;i<m;i++){
			System.out.println("number "+number+" a "+i);
			for(Long j=0L;j<m;j++){
				if(sn1==((i*sn)+j)%m){
					result.add(new Pair(i, j));
				}
			}
		}
		flag=false;
	}
	
}
