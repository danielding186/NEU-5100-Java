package assignment5;

public class Sundae extends IceCream {
	
	public Sundae(String name, int price, String sundae, int sundaePrice) {
		super(sundae + " Sundae with\n" + name, price + sundaePrice);
	}
}
