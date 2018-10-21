package assignment6.partc;

import java.util.Calendar;

public class Pet {
	public enum SexID {
		MALE, FEMALE, SPAYED, NEUTERED,
	};

	private String name, ownerName, color;
	protected SexID sexid;
	
	private Calendar boardStart, boardEnd;
	
	public Pet(String name, String ownerName, String color) {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}

	public void setSex(SexID sexid) {
		this.sexid = sexid;
	}

	public String getSex() {
		switch (this.sexid) {
			case MALE:
				return "Male";
			case FEMALE:
				return "Female";
			case SPAYED:
				return "Spayed";
			default:
				return "Neutered";
		}
	}
	
	private boolean checkIsValidDate(int month, int day, int year) {
		if (month <= 0 || month > 12)
			return false;
		
		if (day <= 0 || day > 31)
			return false;
		
		if (year >= 10000)
			return false;
		
		return true;
	}
	
	public void setBoardStart(int month, int day, int year) {
		
		if (!checkIsValidDate(month, day, year))
			return;
		
		// note: we have to set the hour, minute and second to 0
		this.boardStart = Calendar.getInstance();
		this.boardStart.set(year, month, day, 0, 0, 0);
	}
	
	public void setBoardEnd(int month, int day, int year) {
		if (!checkIsValidDate(month, day, year))
			return;
			

		this.boardEnd = Calendar.getInstance();
		this.boardEnd.set(year, month, day, 0, 0, 0);
	}
	
	public boolean boarding(int month, int day, int year) {
		if (!checkIsValidDate(month, day, year))
			return false;
		
		if (this.boardStart == null || this.boardEnd == null)
			return true;
		
		Calendar boarding = Calendar.getInstance();
		boarding.set(year, month, day, 0, 0, 0);
		if (boarding.compareTo(this.boardStart) >= 0 && 
				boarding.compareTo(this.boardEnd) <= 0)
			return true;
		
		return false;
	}
	
	public String toString() {
		return String.format("%s owned by %s\nColor: %s\nSex: %s",
				this.name, this.ownerName, this.color, getSex());
	}
	
	public static void main(String[] args) {
		Pet pet = new Pet("Spot", "Mary", "Black and White");
		pet.setSex(SexID.MALE);
		System.out.print(pet);
	}
}
