package assignment6.partc;

public class Dog extends Pet implements Boardable {
	
	private String size;
	
	public Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public String toString() {
		return String.format("DOG:\n%s\nSize: %s",
				super.toString(), this.size);
	}

	public static void main(String[] args) {
		Dog dog = new Dog("Spot", "Susan", "white", "medium");
		dog.setSex(SexID.SPAYED);

		System.out.println(dog);
		
		dog.setBoardStart(10, 9, 2018);
		dog.setBoardEnd(11, 10, 2018);
		System.out.println("boarding = " + dog.boarding(10, 11, 2018));
		System.out.println("boarding = " + dog.boarding(10, 9, 2018));
		System.out.println("boarding = " + dog.boarding(11, 10, 2018));
		System.out.println("boarding = " + dog.boarding(9, 11, 2018));
		System.out.println("boarding = " + dog.boarding(11, 11, 2018));
	}

}
