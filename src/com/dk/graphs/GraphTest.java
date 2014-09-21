package com.dk.graphs;

import java.io.FileNotFoundException;

public class GraphTest {


	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter fileName ");
		// String fileName = scanner.nextLine();
		Graph graph = new Graph("cities.txt");
		graph.printGraph();
		// traversing
		// depth first search
		// graph.dfsDriver();
		// breadth first
//		graph.bfsDriver();
		//Thread.sleep(100);
		graph.getPath(2);
		
		// Printe detail about each node

		System.out.println("\n\n\n vertices detail ");
		// graph.printGraph();
		for (int i = 0; i < graph.vertices.length; i++) {
			System.out.println(graph.vertices[i]);
		}

		// graph.queue.add(graph.vertices[0]);
		// graph.bfsRecur();
	}


}
