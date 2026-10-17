package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entities.Employees;

public class Program {

	private static final String ANSI_BOLD = "\u001B[1m";
	private static final String ANSI_RESET = "\u001B[0m";
	
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_BLUE = "\u001B[34m";
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Employees> employeesDataList = new ArrayList<>();
		
		String path = null;
		
		System.out.println(ANSI_BOLD + ANSI_BLUE + "\n\t\t---NAMES FILE READER---\n" + ANSI_RESET);
		System.out.println(ANSI_BOLD + ANSI_GREEN + "A part of the code, to read a text file, containing names, create a list "
				+ "\nwith those and return each name from the list sorted on the screen."
				+ ANSI_RESET);
		System.out.print(ANSI_RED + "\nPlease, enter with the path of the text(.txt) file: " + ANSI_RESET);
		path = sc.next();
		System.out.println();

		try (BufferedReader br1 = new BufferedReader(new FileReader(path))) {

			String eCSV = br1.readLine();
			while (eCSV != null) {
				String[] fields = eCSV.split(", ");
				employeesDataList.add(new Employees(fields[0], Double.parseDouble((fields[1]))));
				eCSV = br1.readLine();
			}
			Collections.sort(employeesDataList);
			for (Employees emp: employeesDataList) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
