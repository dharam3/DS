/**
 * 
 */
package com.dk.graphs;

/**
 * @author d35kumar
 *
 */
class Neighbor {
	int vertexNo;
	int weight;
	Neighbor next;

	public Neighbor(int vertexNo, Neighbor next, int weight) {
		this.vertexNo = vertexNo;
		this.next = next;
		this.weight=weight;
	}

	@Override
	public String toString() {
		return "Neighbor [vertexNo=" + vertexNo + ", next=" + next + "]";
	}
}
