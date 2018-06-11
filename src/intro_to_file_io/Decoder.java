package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Decoder {
	
public static void main(String[] args) {
	

	
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		
		try {
			//	FileReader fr = new FileReader("jfc.getSelectedFile().getAbsolutePath()");
				FileReader fr = new FileReader("src/intro_to_file_io/savefile.txt");
				int c = fr.read();
				while(c != -1){
					char x = (char)c;
					x-=1;
					System.out.print(x);
					c = fr.read();
					
				}
				fr.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		jfc.getSelectedFile().getAbsolutePath();
		
	}
}
}
