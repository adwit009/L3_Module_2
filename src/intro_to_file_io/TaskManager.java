package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TaskManager implements ActionListener {

	JButton b1 = new JButton("add task");
	JButton b2 = new JButton("remove task");
	JButton b3 = new JButton("save");
	JButton b4 = new JButton("load");
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	static ArrayList<String> tasks = new ArrayList();

	TaskManager() {
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		TaskManager toDoList = new TaskManager();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/ToDoList.txt"));

			String line = br.readLine();
			while (line != null) {
				tasks.add(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {

			String input = JOptionPane.showInputDialog("Enter the task you want to add");
			tasks.add(input);
		}
		if (e.getSource() == b2) {
			if (tasks.isEmpty() == true) {
				JOptionPane.showMessageDialog(null, "There are no tasks");
			} else {

				String allTasks = "";

				for (int i = 0; i < tasks.size(); i++) {
					String task = tasks.get(i);
					allTasks += i + 1 + "     ";
					allTasks += task + "\n";

				}

				String remove = JOptionPane
						.showInputDialog("Select the task you want to remove by entering its number \n" + allTasks);
				int x = Integer.parseInt(remove);
				if (x > tasks.size() || x < 1) {
					JOptionPane.showMessageDialog(null, "This is not a valid task number");
				} else {

					x -= 1;
					tasks.remove(x);
				}
			}
		}
		if (e.getSource() == b3) {
			String allTasks = "";
			JOptionPane.showMessageDialog(null, "Saving your list");
			for (int i = 0; i < tasks.size(); i++) {
				allTasks += tasks.get(i) + "\n";
			}
			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/ToDoList.txt");

				/*
				 * NOTE: To append to a file that already exists, add true as a second parameter
				 * when calling the FileWriter constructor. (e.g. FileWriter fw = new
				 * FileWriter("src/intro_to_file_io/test2.txt", true);)
				 */

				fw.write(allTasks);

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}
		if (e.getSource() == b4) {
			// JOptionPane.showMessageDialog(null, "Please choose the save file");

	
	tasks.clear(); 


			try {
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/ToDoList.txt"));

				String line = br.readLine();
				while (line != null) {
					tasks.add(line);
					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			
			
			
		}
	}
}
//Copyright © 2018 by Adwit Aggarwal 