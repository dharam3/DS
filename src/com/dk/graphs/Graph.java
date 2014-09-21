/**
 * 
 */

package com.dk.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author d35kumar
 * 
 */
/**
 * @author d35kumar
 * 
 */
public class Graph {

	Vertex vertices[];

	/**
	 * @throws FileNotFoundException
	 * 
	 */
	public Graph(String fileName) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileName));
		String next = scanner.nextLine();
//		System.out.println("==>" + next);
		boolean weighted = next.equals("weighted") ? true : false;
		next = scanner.nextLine();
		boolean directed = next.equals("directed") ? true : false;

		System.out.println("Processing Weighted " + weighted + "  Directed "
				+ weighted + " ");
		vertices = new Vertex[scanner.nextInt()];
		// read the vertex
		System.out.println();
		for (int i = 0; i < vertices.length; i++) {
			String name = scanner.next();
			System.out.println("Vertex name " + name);
			vertices[i] = new Vertex(name, null);
		}

		// read the edges for adjacency list
		while (scanner.hasNext()) {
			int v1 = indexForName(scanner.next());
			int v2 = indexForName(scanner.next());
			int weight=0;
			if(weighted){
				weight= scanner.nextInt();
			}

			vertices[v1].adjList = new Neighbor(v2, vertices[v1].adjList, weight);
			if (!directed) {
				vertices[v2].adjList = new Neighbor(v1, vertices[v2].adjList, weight);
			}
		}
		scanner.close();
	}

	/**
	 * 
	 */
	public void bfsDriver() {
		for (int i = 0; i < vertices.length; i++) {
			if (!vertices[i].visited) {
				Queue<Vertex> queue = new LinkedList<>();
				queue.add(vertices[i]);
				bfs(queue);
			}
		}
	}

	/**
	 * @param queue
	 */
	private void bfs(Queue<Vertex> queue) {
		while (!queue.isEmpty()) {
			Vertex vertex1 = queue.remove();
			if (!vertex1.visited) {
				vertex1.visited = true;
				System.out.println("Visiting " + vertex1.name);
			}
			Neighbor adjList = vertex1.adjList;
			while (adjList != null) {
				Vertex vertex2 = vertices[adjList.vertexNo];
				vertex2.inOrder++;
				vertex1.outOrder++;
				if (!vertex2.visited) {
					System.out.println("Visiting " + vertex2.name);
					vertex2.visited = true;
					queue.add(vertex2);
				}
				adjList = adjList.next;
			}

		}
	}

	// Queue<Vertex> queue = new LinkedList<>();
	// private void bfsRecur() {
	//
	//
	// Vertex vertex1 = queue.remove();
	//
	// if (!vertex1.visited) {
	// vertex1.visited = true;
	// System.out.println("Visiting " + vertex1.name);
	// }
	//
	// Neighbor adjList = vertex1.adjList;
	// while (adjList != null) {
	// Vertex vertex2 = vertices[adjList.vertexNo];
	// if (!vertex2.visited) {
	// System.out.println("Visiting " + vertex2.name);
	// vertex2.visited = true;
	// queue.add(vertex2);
	// }
	// adjList = adjList.next;
	// }
	//
	// if (!queue.isEmpty())
	// bfsRecur();
	//
	// }

	public void dfsDriver() {
		for (int i = 0; i < vertices.length; i++) {
			if (!vertices[i].visited) {
				System.out.println("Restarting with " + vertices[i]);
				dfs(i);
			}
		}
	}

	private void dfs(int vertexNo) {
		vertices[vertexNo].visited = true;
		System.out.println("Visiting " + vertices[vertexNo]);
		for (Neighbor adjList = vertices[vertexNo].adjList; adjList != null; adjList = adjList.next) {
			if (!vertices[adjList.vertexNo].visited) {
				dfs(adjList.vertexNo);
			}
		}
	}

	/**
	 * Returns path from <code>from</code> node to each node
	 * 
	 * @param from
	 * @return path to each node
	 */
	public Path[] getPath(int from) {
		Path[] path = null;

		Queue<Vertex> queue = new LinkedList<>();

		queue.add(vertices[from]);

		vertices[from].path.distance = 0;
		while (!queue.isEmpty()) {
			Vertex v = queue.remove();
			System.out.println("Processing vertex  " + v.name);
			Neighbor adjList = v.adjList;
			while (adjList != null) {
				Vertex v2 = vertices[adjList.vertexNo];
				if (v2.path.distance == Integer.MAX_VALUE) {
					v2.path.distance = v.path.distance + 1;
					v2.path.through = v.name;
					queue.add(v2);
				}
				adjList = adjList.next;
			}

		}

		return path;
	}

	/**
	 * Give the name and it will return you the index of that in vertices array
	 * 
	 * @param vertexName
	 * @return index of vertex if found, else -1
	 */
	private int indexForName(String vertexName) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertexName.equals(vertices[i].name)) {
				return i;
			}
		}
		return -1;

	}

	/**
	 * Print the graph in simple format
	 */
	public void printGraph() {
		System.out.println("\n\n\n-----------------------------------");
		for (int i = 0; i < vertices.length; i++) {
			System.out.print(vertices[i].name);
			Neighbor head = vertices[i].adjList;
			while (head != null) {
				Vertex v = vertices[head.vertexNo];
				System.out.print("-->" + v.name);
				head = head.next;
			}
			System.out.println();
		}
	}

}
