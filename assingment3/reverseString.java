
public class reverseString {

	
	public static String reverse(String s) {
		
		s = s.trim();
		String tmp[] = s.split("\\s+");
		s = "";
		for (int i = tmp.length - 1; i >=0; i--)
			s += tmp[i] + " ";
		
		s = s.trim();
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print(reverse(" The sky  is   blue "));
	}

}
