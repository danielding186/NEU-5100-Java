abstract class MoodyObject {
	protected abstract String getMood();
	protected abstract void expressFeelings();
	
	public void queryMood() {
		String mood = getMood();
		System.out.println("I feel " + mood + " today!");
	}

}

class SadObject extends MoodyObject {

	protected String getMood() {
		return "sad";
	}
	
	public String toString() {
		return "Subject cries a lot";
	}
	
	public void expressFeelings() {
		System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
	}
}

class HappyObject extends MoodyObject {
	public String getMood() {
		return "happy";
	}
	
	public String toString() {
		return "Subject laughs a lot";
	}
	
	public void expressFeelings() {
		System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
	}
}



public class PsychiatristObject {
	
	public void examine(MoodyObject moodyObject) {
		System.out.println("How are you feeling today?");
		moodyObject.queryMood();
		System.out.println();
		moodyObject.expressFeelings();
	}
	
	public void observe(MoodyObject moodyObject) {
		System.out.println("Observation: " + moodyObject);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PsychiatristObject psy = new PsychiatristObject();
		
		HappyObject happy = new HappyObject();
		psy.examine(happy);
		psy.observe(happy);
		
		System.out.println();
		
		SadObject sad = new SadObject();
		psy.examine(sad);
		psy.observe(sad);
		
	}

}
