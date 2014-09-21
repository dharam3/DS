/**
 * 
 */
package com.dk.graphs;

/**
 * @author d35kumar
 *
 */
public class Path {
	/**
	 * Distance from source vertex
	 */
	int distance=Integer.MAX_VALUE;
	/**
	 * Name of the vertices through which we got this path
	 */
	String through;
	/**
	 * 
	 */
	public Path() {
	}
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("Distance= ");
		sb.append(distance);
		if(through!=null){
			sb.append(" via ");
			sb.append(through);
		}
		return sb.toString();
	}
	
	

}
