package lcg;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BrutalForceMaintenance {

	
	public BrutalForceMaintenance(){
		
	}
	public void crackLCGParams(int threadsQuantitity,ArrayList<Long> input ,Long m){

		//2,147,483,647
		ArrayList<BrutalForceThread> threads= new ArrayList<BrutalForceThread>();
		
		for(int i=0;i<threadsQuantitity;i++){
			
			threads.add(new BrutalForceThread
					(i, input.get(0), input.get(1), input.get(2), input.get(3),m,i*(m/threadsQuantitity), (i+1)*m/threadsQuantitity));
		}
			

	
		for(int i=0;i<threadsQuantitity;i++){
			threads.get(i).start();
		}
		
	}
}
