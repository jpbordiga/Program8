// JEFF BORDIGA
// PROGRAM08
// 11/13/17

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StringMain {

	private static final String OUTPUT = "output.txt";
	
	public static void main(String[] args) {
		
		
		boolean correctFile = false;
		PrintWriter outputStream = null;
		Scanner keyboard = new Scanner(System.in);
		String chosenFile = null;
		Scanner inFile = null;
		ArrayList<String> stringList = new ArrayList<>();
		
		String[] files = new String[3]; // list of input files is used for whole output file
		files[0] = "textInput1.txt"; // storing files as a group
		files[1] = "textInput2.txt";
		files[2] = "textInput3.txt";
		
		try {
			
			while(correctFile == false) { // user input phase
				
				System.out.println("Choose a file to use: ");
					
				chosenFile = keyboard.next();
					
				for(int b = 0; b < files.length; b++) {
					if(chosenFile.equals(files[b])) {
						correctFile = true;
					}
				}
					
				if(correctFile == false) {
					System.out.println("ERROR: the file \"" + chosenFile + "\" could not be found" + "\n");
				}
					
			}
		
			outputStream = new PrintWriter(new FileOutputStream(OUTPUT));
			inFile = new Scanner(new FileInputStream(chosenFile));
			QuickSort qS = new QuickSort();
			
			while(inFile.hasNextLine() == true) { // reading in Strings
				stringList.add(inFile.nextLine());
			}
			
			qS.randomizedQuickSort(stringList, 0, stringList.size() - 1); // sorts the input
			
			assert(stringList.size() != 0);
			
			for(String s : stringList) { // output phase
				
				outputStream.println(s);
				
			}

			outputStream.close();
			System.out.println("Sort complete");
			
		} catch(FileNotFoundException e){
			System.out.println("ERROR: unable to open file " + OUTPUT);
			System.exit(0);
		}
		
	}

}
