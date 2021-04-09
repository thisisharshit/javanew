package SortedCollections;
import java.lang.*;
public class StockItem implements Comparable<StockItem>{
	private final String name;
	private double price;
	private int quantitystock=0;
	public StockItem(String name, double price) {
		this.name=name;
		this.price=price;
		this.quantitystock=0;
	}
	
	
	public StockItem(String name, double price, int quantitystock) {
		
		this.name = name;
		this.price = price;
		this.quantitystock = quantitystock;
	}


	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int quantityInStock() {
		return quantitystock;
	}
	public void setPrice(double price) {
		if(price>0) {
			this.price=price;
		}
	}
	public void adjustStock(int quantity) {
		int newQuantity=this.quantitystock+quantity;
		if(newQuantity>=0) {
			this.quantitystock=newQuantity;
		}
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("entering stockitem.equals()");
		if(obj==this) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		String objname=((StockItem)obj).getName();
		return this.name.equals(objname);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode()+31;//constant can be any number
	}
	
	@Override
	public String toString() {
		return this.name+" : price "+this.price;
	}


	@Override
	public int compareTo(StockItem o) {
		// TODO Auto-generated method stub
		
		System.out.println("entering stockitem.compareto()");
		if(this==o) {
			return 0;
		}
		if(o!=null) {
			return this.name.compareTo(((StockItem) o).getName());
		}
		throw new NullPointerException();
	}
	
	
	
	
}
