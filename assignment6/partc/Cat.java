package assignment6.partc;

public class Cat extends Pet implements Boardable {
	
	private String hairLength;
	
	
	public Cat(String name, String ownerName, String color, String hairLength) {
		super(name, ownerName, color);
		this.hairLength = hairLength;
	}
	
	public String getHairLength() {
		return this.hairLength;
	}
	
	public String toString() {
		return String.format("CAT:\n%s\nHair: %s",
				super.toString(), this.hairLength);
	}

	public static void main(String[] args) {
		Cat cat = new Cat("Tom", "Bob", "black", "short");
		cat.setSex(SexID.SPAYED);
		System.out.println(cat);
		
		cat.setBoardStart(10, 9, 2017);
		cat.setBoardEnd(11, 10, 2018);
		System.out.println("boarding = " + cat.boarding(10, 11, 2018));
		System.out.println("boarding = " + cat.boarding(10, 9, 2018));
		System.out.println("boarding = " + cat.boarding(11, 10, 2018));
		System.out.println("boarding = " + cat.boarding(9, 11, 2018));
		System.out.println("boarding = " + cat.boarding(11, 11, 2018));

	}
}
