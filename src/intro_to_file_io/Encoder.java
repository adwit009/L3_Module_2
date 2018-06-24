package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Encoder {
public static void main(String[] args) {
	try {
		FileWriter fw = new FileWriter("src/intro_to_file_io/savefile.txt");
		
		/*
		NOTE: To append to a file that already exists, add true as a second parameter when calling the
		      FileWriter constructor.
		      (e.g. FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);)
		*/
		String text = JOptionPane.showInputDialog("Enter a message");
	String encrypted = ""; 
		for (int i = 0; i < text.length(); i++) {
			
			char x =text.charAt(i);
			x+=1;
			encrypted+= x;
		}
		fw.write(encrypted);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
//Copyright © 2018 by Adwit Aggarwal 