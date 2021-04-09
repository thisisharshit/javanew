package SortedCollections;

import java.util.Map.Entry;
import java.util.*;

public class Main {
	private static StockList stocklist=new StockList();
	public static void main(String[] args) {
		StockItem temp=new StockItem("bread", 0.86,100);
		stocklist.addStock(temp);
		temp=new StockItem("cake", 1.1,7);
		stocklist.addStock(temp);
		
		temp=new StockItem("chair", 62,10);
		stocklist.addStock(temp);
		temp=new StockItem("car", 12.5,2);
		stocklist.addStock(temp);
		temp=new StockItem("cup", 0.5,200);
		stocklist.addStock(temp);
		temp=new StockItem("cup",0.45,7);
		stocklist.addStock(temp);
		temp=new StockItem("door", 72.95,4);
		stocklist.addStock(temp);
		temp=new StockItem("juice", 2.5,36);
		stocklist.addStock(temp);
		temp=new StockItem("phone", 96.99,35);
		stocklist.addStock(temp);
		temp=new StockItem("towel", 2.4,80);
		stocklist.addStock(temp);
		temp=new StockItem("vase", 8.76,40);
		stocklist.addStock(temp);
		
		System.out.println(stocklist);
		/*for(String s:stocklist.Items().keySet()) {
			 System.out.println(s);
		}*/
		
		Basket timsBasket=new Basket("tim");
		sellItem(timsBasket, "car", 1);
		System.out.println(timsBasket);
		sellItem(timsBasket, "car", 1);
		System.out.println(timsBasket);
		
		if(sellItem(timsBasket, "car", 1)!=1) {
			System.out.println("there are no more cars in the stock");
		}
		
		sellItem(timsBasket, "spanner", 10);
		System.out.println(timsBasket);
		sellItem(timsBasket, "juice", 4);
		sellItem(timsBasket, "cup", 12);
		sellItem(timsBasket, "bread", 1);
		System.out.println(timsBasket);
		
		System.out.println(stocklist);
		
		//temp = new StockItem("pen", 1.12);
        //stocklist.Items().put(temp.getName(), temp); //gives error because we are using unmodifiable map function
        
        stocklist.Items().get("car").adjustStock(2000);
        stocklist.get("car").adjustStock(-1000);
        System.out.println(stocklist);
        for(Map.Entry<String, Double> price : stocklist.pricelist().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
	}
	public static int sellItem(Basket basket, String item, int 	quantity) {
		StockItem stockitem=stocklist.get(item);
		if(stockitem==null) {
			System.out.println("we don't sell "+item);
			return 0;
		}
		if(stocklist.sellStock(item, quantity)!=0) {
			basket.addToBasket(stockitem, quantity);
			return quantity;
		}
		return 0;
	}
}
