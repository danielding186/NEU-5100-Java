package assignment5;
import java.util.Vector;

public class Checkout {
	Vector<DessertItem> items;
	
	public Checkout() {
		items = new Vector<DessertItem>();
	}
	
	public int numberOfItems() {
		return items.size();
	}
	
	public void enterItem(DessertItem item) {
		if (item == null)
			return;
		
		items.add(item);
	}
	
	public void clear() {
		items.clear();
	}
	
	public int totalCost() {
		int total = 0;
		for (DessertItem item : items) {
			total += item.getCost();
		}
		return total;
	}
	
	public int totalTax() {
		return Math.round(totalCost() * DessertShoppe.TaxRate);
	}
	
	public String toString() {
		StringBuffer display = new StringBuffer();
		
		final String minSpace = "   ";
		
		// print the head part
		int spaceSize = (DessertShoppe.MaximumWidth4Name + 5 - DessertShoppe.ShoppeName.length())/2;
		for (int i = 0; i < spaceSize; i++)
			display.append(" ");
		
		display.append(DessertShoppe.ShoppeName + "\n");
		
		for (int i = 0; i < spaceSize; i++)
			display.append(" ");
		
		for (int i = 0; i < DessertShoppe.ShoppeName.length(); i++) {
			display.append('-');
		}
		display.append("\n\n");
		
		// print every item
		for (DessertItem item : items) {
			
			// print the name line by line
			String lines[] = item.name.split("\n");
			for (String line : lines) {
				String formatStr = "%-" + DessertShoppe.MaximumWidth4Name + "." + DessertShoppe.MaximumWidth4Name + "s";
				display.append(String.format(formatStr, line));
				display.append("\n");
			}
			
			// replace the last '\n' with space
			display.replace(display.length()-1, display.length(), minSpace);
			
			// print the cost
			String formatStr = "%-" + DessertShoppe.MaximumWidth4Costs + "." + DessertShoppe.MaximumWidth4Costs + "s";
			display.append(String.format(formatStr, DessertShoppe.cents2dollarsAndCentsmethod(item.getCost())));
			display.append("\n");
		} 
		
		display.append("\n");
		
		String formatStr = "%-" + DessertShoppe.MaximumWidth4Name + "." + DessertShoppe.MaximumWidth4Name + "s";
		String tax = DessertShoppe.cents2dollarsAndCentsmethod(totalTax());
		display.append(String.format(formatStr, "Tax") + minSpace + String.format("%s", tax));
		display.append("\n");
		
		String cost = DessertShoppe.cents2dollarsAndCentsmethod(totalTax() + totalCost());
		display.append(String.format(formatStr, "Total Cost") + minSpace + String.format("%s", cost));
		
		return display.toString();
	}
	
}
