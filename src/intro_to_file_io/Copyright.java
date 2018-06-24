package intro_to_file_io;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Copyright {
public static void main(String[] args) {
	ArrayList <String> directoryNames = new ArrayList();
	File src = new File("src");
	File[] allFiles = src.listFiles();
	
	for (int i = 0; i < allFiles.length; i++) {
		if (allFiles[i].isDirectory()) {
			directoryNames.add(allFiles[i].toString());
		}
	}
	for (int i = 0; i < directoryNames.size(); i++) {
		ArrayList <String> files = getFileNamesInARepo(directoryNames.get(i));
		addCopyright(files);
	}
		
	}

static ArrayList<String> getFileNamesInARepo(String repoName) {
	File repo = new File(repoName);
	File[] allFilesInRepo = repo.listFiles();
	ArrayList <String> names = new ArrayList();  
	for (int i = 0; i < allFilesInRepo.length; i++) {
		String name = allFilesInRepo[i].toString(); 
		names.add(name);
	}
	return names;
}

static void addCopyright(ArrayList<String> files) {
	for (int i = 0; i < files.size(); i++) {
		if (files.get(i).contains(".java")) {
			String javaFileName = files.get(i);
			try {
				FileWriter fw = new FileWriter(javaFileName, true);
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);)
				*/
				
				fw.write("//Copyright © 2018 by Adwit Aggarwal ");
					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}

}

//Copyright © 2018 by Adwit Aggarwal 