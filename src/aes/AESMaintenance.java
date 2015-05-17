package aes;

public class AESMaintenance {

	public enum Mode {
		 
	    OFB("OFB"),
	    CTR("CTR"),
	    CBC("CBC");
	 
	    String description;
	 
	    private Mode(String description) {
	    	this.description = description;
	    }
	}
	
	
}
