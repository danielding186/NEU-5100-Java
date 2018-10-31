package assignment7;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ParseFile {

	public static void parse(File file) throws IOException {
		   RandomAccessFile input = null;
		   String line = null;
		   try {
		       input = new RandomAccessFile(file, "r");
		       while ((line = input.readLine()) != null) {
		           System.out.println(line);
		       }
		       return;  
		   } finally {
		       if (input != null) {
		           input.close();
		       }
		   }
		}
	
	public static void main(String[] args) {
		ParseFile parseFile = new ParseFile();
		
		try {
			ClassLoader classLoader = parseFile.getClass().getClassLoader();
			File file = new File(classLoader.getResource("resources/1.txt").getFile());
			parse(file);
		} catch (IOException e) {
			System.out.println(e);
		}
	

	}

}
