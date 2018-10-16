package assignment5;
public class Candy extends DessertItem {
	
	private float weight;
	private int price;
	
	public Candy(String name, float weight, int price) {
		super(String.format("%.2f lbs. @ %s /lb.\n", weight, 
				DessertShoppe.cents2dollarsAndCentsmethod(price)) 
				+ name);
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int getCost() {
		return Math.round(this.weight * this.price);
	}
	
}