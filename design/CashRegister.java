package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CashRegister {
	private Coin[] coins = {new Coin("HUNDRED", 100), new Coin("FIFTY", 50), 
			new Coin("TWENTY", 20), new Coin("TEN", 10), new Coin("FIVE", 5), 
			new Coin("TWO", 2), new Coin("ONE", 1), new Coin("HALF DOLLAR", 0.50), 
			new Coin("QUARTER", .25), 
			new Coin("DIME", 0.10), new Coin("NICKEL", 0.05), new Coin("PENNY", 0.01)};
	private double TOLERANCE = 0.01;
	public List<String> getChange(double purchasePrice, double cash){
		List<String> change = new ArrayList<>();
		if(cash == purchasePrice){
			change.add("ZERO");
			return change;
		}
		
		if(cash < purchasePrice) {
			change.add("ERROR");
			return change;
		}
		
		double diff = cash - purchasePrice;
		while(diff > TOLERANCE) {
			for(int i = 0; i < coins.length; i++) {
				if(coins[i].getValue() <= diff) {
					diff -= coins[i].getValue();
					change.add(coins[i].getName());
				}
			}
		}
		
		Collections.sort(change);
		return change;
	}
}

class Coin{
	private String name;
	private double value;
	Coin(String name, double value){
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return value;
	}
}
