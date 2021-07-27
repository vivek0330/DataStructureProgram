/**
* <h1>Welcome to the data structure problem !!</h1> 
* The Data Structure Program implements an application that
* simply displays "Welcome to the data structure problem !!" to the standard output.
* 
* @author Official_vk
* @version 1.0
* @since 2021-07-28
*/

package Com.DataStructureProblem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataStructureProblem<T> {
	private static LinkedList<String> list = new LinkedList<String>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// Prints Welcome to the data structure problem !! on standard output.
		System.out.println("Welcome to the data structure problem !!");
		System.out.println(" "); // single line space generate 
		readFile();
		System.out.println("Enter a word from list to search");
		String searchWord = sc.nextLine();
		int searchResult = list.searchByValue(searchWord);
		if (searchResult == -1) {
			list.add(searchWord);
		} else {
			list.removeAtIndex(searchResult);
		}
		writeFile();
	}

	// This method writes an output file
	private static void writeFile() throws IOException {
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			str = str.concat(list.get(i)).concat(" ");
		}
		FileWriter fw = new FileWriter("C:\\Users\\vivek kumar\\eclipse-workspace\\DataStructureProblem\\DataStructureProgram\\Files\\Unorderlist.txt");
		for (int i = 0; i < str.length(); i++)
			fw.write(str.charAt(i));
		System.out.println("Writing successful");
		fw.close();
	}

	// This method reads an input file
	private static void readFile() throws IOException {
		int ch;
		FileReader fr = null;
		String lines = "";
		try {
			fr = new FileReader("C:\\\\Users\\\\vivek kumar\\\\eclipse-workspace\\\\DataStructureProblem\\\\DataStructureProgram\\\\Files\\\\input.txt");
		} catch (FileNotFoundException fe) {
			System.out.println("File not found");
		}
		// read from FileReader till the end of file
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
			lines = lines.concat(String.valueOf((char) ch));
		}
		System.out.println();
		fr.close();
		String[] wordArray = lines.split(" ");
		for (String word : wordArray) {
			list.add(word);
		}
	}

}
