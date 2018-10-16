package assignment5;

public class DessertShoppe {
	 public final static String ShoppeName = "M & M Dessert Shoppe";
	 public final static float TaxRate = 0.065f;
	 public final static int MaximumWidth4Name = 30;
	 public final static int MaximumWidth4Costs = 20;
	 
	 
	 public static String cents2dollarsAndCentsmethod(int cents) {
		 String centStr = String.format("%.2f", cents/100.);
		 centStr = centStr.replaceFirst("^0\\.", ".");
		 return centStr;
	 }
}
