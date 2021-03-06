package HelloWorld;


public class composition {
	
	public static void main(String args[]) {
		Dimension dimension = new Dimension(20, 20, 5);
		Case theCase = new Case("220B", "Dell", "220", dimension);
		monitor theMonitor = new monitor("27 inch beast","acer",27,new Resolution(2540,1440));
		motherboard theMotherboard = new motherboard("BJ-200", "asus", 4,6, "v2.44");
		PC thePc= new PC(theCase, theMonitor, theMotherboard);
		/*thePc.getTheMonitor().drawpixelat(1500,1200,"red");
		thePc.getTheMotherboard().loadprogram("windows 10");
		thePc.getThecase().presspowerbutton();
		*/
		thePc.powerup();
	}

}
class PC{
	private Case thecase;
	private monitor theMonitor;
	private motherboard theMotherboard;
	public PC(Case thecase, monitor theMonitor, motherboard theMotherboard) {
		this.thecase = thecase;
		this.theMonitor = theMonitor;
		this.theMotherboard = theMotherboard;
	}
	public void powerup() {
		thecase.presspowerbutton();
		drawlogo();
	}
	private void drawlogo() {
			//fancy graphics
		theMonitor.drawpixelat(1200, 50, "yellow");
	}
	private Case getThecase() {
		return thecase;
	}
	public void setThecase(Case thecase) {
		this.thecase = thecase;
	}
	private monitor getTheMonitor() {
		return theMonitor;
	}
	public void setTheMonitor(monitor theMonitor) {
		this.theMonitor = theMonitor;
	}
	private motherboard getTheMotherboard() {
		return theMotherboard;
	}
	public void setTheMotherboard(motherboard theMotherboard) {
		this.theMotherboard = theMotherboard;
	}
	
}
class motherboard{
	private String model;
	private String manufacturer;
	private int ramslots;
	private int cardslots;
	private String bios;
	public motherboard(String model, String manufacturer, int ramslots, int cardslots, String bios) {
		
		this.model = model;
		this.manufacturer = manufacturer;
		this.ramslots = ramslots;
		this.cardslots = cardslots;
		this.bios = bios;
	}
	public void loadprogram(String s) {
		System.out.println("loading "+s);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getRamslots() {
		return ramslots;
	}
	public void setRamslots(int ramslots) {
		this.ramslots = ramslots;
	}
	public int getCardslots() {
		return cardslots;
	}
	public void setCardslots(int cardslots) {
		this.cardslots = cardslots;
	}
	public String getBios() {
		return bios;
	}
	public void setBios(String bios) {
		this.bios = bios;
	}	
}
class monitor{
	private String model;
	private String manufacturer;
	private int size;
	private Resolution nativeresolution;
	
	public monitor(String model, String manufacturer, int size, Resolution nativeresolution) {
		
		this.model = model;
		this.manufacturer = manufacturer;
		this.size = size;
		this.nativeresolution = nativeresolution;
	}
	public void drawpixelat(int x, int y, String color) {
		System.out.println(x+" "+y+" "+color);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Resolution getNativeresolution() {
		return nativeresolution;
	}
	public void setNativeresolution(Resolution nativeresolution) {
		this.nativeresolution = nativeresolution;
	}
	
}
class Resolution{
	private int w,h;

	public Resolution(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
}
class Case{
	private String model,manufacturer,powersupply;
	private Dimension dimension;
	public Case(String model, String manufacturer, String powersupply, HelloWorld.Dimension dimension) {
		
		this.model = model;
		this.manufacturer = manufacturer;
		this.powersupply = powersupply;
		this.dimension = dimension;
	}
	public void presspowerbutton() {
		System.out.println("power button pressed");
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getPowersupply() {
		return powersupply;
	}
	public void setPowersupply(String powersupply) {
		this.powersupply = powersupply;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
		
}
class Dimension{
	private int w,h,d;

	public Dimension(int w, int h, int d) {
		this.w = w;
		this.h = h;
		this.d = d;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
}