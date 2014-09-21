/**
 * 
 */
package com.dk.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author d35kumar
 *
 */
public class GraphProblems {
	private static final String filename="graphData";
	
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner= new Scanner(file);
		while(scanner.hasNextLine()){
			System.out.println(" "+scanner.nextLine());
		}
		
		scanner.close();
	}

}
