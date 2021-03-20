package HelloWorld;


public class car {
	
	private int doors;
	private int wheels;
	private String model;
	private String engine,colour;
	
	public void setmodel(String model) {
		String validmodel =model.toLowerCase();
		if(validmodel=="carrera" || validmodel.equals("commodore")) {
			this.model=model;
		}else {
			this.model="unknown";
		}
	}
	public String getmodel() {
		return this.model;
	}
	
	

}
