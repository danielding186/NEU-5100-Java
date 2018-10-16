package assignment5;

public class Cookie extends DessertItem {
	private int number;
	private int price;
	
	public Cookie(String name, int number, int price) {
		super(String.format("%d @ %.2f /dz.\n", number, price/100.f) + name);
		this.number = number;
		this.price = price;
	}
	
	@Override
	public int getCost() {
		return (int) Math.round(number * price / 12.0);
	}

}
