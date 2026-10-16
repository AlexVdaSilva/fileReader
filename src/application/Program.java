package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {

	private static final String ANSI_BOLD = "\u001B[1m";
	private static final String ANSI_RESET = "\u001B[0m";
	
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_ORANGE = "\u001B[38;5;208m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_INDIGO = "\u001B[38;5;54m";
	private static final String ANSI_VIOLET = "\u001B[35m";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<String> namesList = new ArrayList<>();

		System.out.println(ANSI_BOLD + ANSI_BLUE + "\n\t\t---NAMES FILE READER---\n" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_GREEN + "A code to read a text file containing names, create a list "
				+ "\nwith those and return each name from the list sorted on the screen."
				+ ANSI_RESET);
		System.out.print(ANSI_RED + "\nPlease, enter with the path of the text(.txt) file: " + ANSI_RESET);
		String path = sc.next();
		System.out.println();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String name = br.readLine();
			while (name != null) {
				namesList.add(name);
				name = br.readLine();
			}
			Collections.sort(namesList);
			for (String s : namesList) {
				System.out.println(s);
			}
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
