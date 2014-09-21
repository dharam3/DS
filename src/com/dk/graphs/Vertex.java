/**
 * 
 */
package com.dk.graphs;

/**
 * @author d35kumar
 *
 */
class Vertex {
	String name;
	Neighbor adjList;
	// These data are not part of vertex, used only for traversing
	boolean visited;
	int inOrder, outOrder;
	
	Path path;

	public Vertex(String name, Neighbor neighbor) {
		this.name = name;
		this.adjList = neighbor;
		path=new Path();
	}


	public void setPath(Path p){
		this.path=p;
	}
	@Override
	public String toString() {
		// return "Vertex [name=" + name + ", adjList=" + adjList + "]";
		return name + /*"  InOrder=" + inOrder + " OutOrder " + outOrder+ */"  "+path;
	}

}
