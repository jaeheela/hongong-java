package ch10.exam08;

import java.io.IOException;

public class FileWriterExample {
	public static void main(String[] args) {
		//방법1
		/*FileWriter fw = null;
		try {
			fw = new FileWriter("file.txt");
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try { 	fw.close(); } catch (IOException e) {	}
		}*/
		
		//방법2
		try( FileWriter fw = new FileWriter("file.txt") ) {
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
