package assignment7;

class Tool {
	int strength;
	char type;
	
	void setStrength(int strength) {
		this.strength = strength;
	}
	
	public Tool(int strength) {
		this.strength = strength;
	}
}

class Paper extends Tool {

	public Paper(int strength) {
		super(strength);
		this.type = 'p';
	}
	

	public boolean fight(Tool t) {
		float strenght = this.strength;
		if (t.type == 's') {
			strenght /= 2.;
		}
		else if (t.type == 'r') {
			strenght *= 2.;
		}
		
		return strenght > t.strength;
	}

}

class Rock extends Tool {

	public Rock(int strength) {
		super(strength);
		this.type = 'r';
	}
	
	public boolean fight(Tool t) {
		float strenght = this.strength;
		if (t.type == 'p') {
			strenght /= 2.;
		}
		else if (t.type == 's') {
			strenght *= 2.;
		}
		
		return strenght > t.strength;
	}

}

class Scissors extends Tool {

	public Scissors(int strength) {
		super(strength);
		this.type = 's';
	}
	
	public boolean fight(Tool t) {
		float strenght = this.strength;
		if (t.type == 'r') {
			strenght /= 2.;
		}
		else if (t.type == 'p') {
			strenght *= 2.;
		}
		
		return strenght > t.strength;
	}
}


class RockPaperScissorsGame{
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}