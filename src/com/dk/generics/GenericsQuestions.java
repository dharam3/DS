/**
 * 
 */
package com.dk.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author d35kumar
 *
 */
public class GenericsQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// List<String> stringList = new ArrayList<>();
		// addUnsafe(stringList, new Integer(5));
		// String s = stringList.get(0);
		// ListIterator<String> iterator= stringList.listIterator();
		// while(iterator.hasNext()){
		// System.out.println(""+iterator.next());
		// }

		Pair<String, Integer> student = new Pair<>("Dharmendra", 34);
		System.out.println(student.getFirst() + "   " + student.getSecond());

		Object a = average("Hello", 0, null,'d');
		System.out.println(a);

	}

	// private static void addUnsafe(List<Object> list, Object obj) {
	// list.add(obj);
	// }

	private static <T> T average(T... a) {
		return a[a.length >> 1];
	}
}

class Pair<T, U> {
	T first;
	U second;

	public Pair() {

	}

	public Pair(T t, U u) {
		first = t;
		second = u;
	}

	/**
	 * @return the first
	 */
	public T getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
	 */
	public void setFirst(T first) {
		this.first = first;
	}

	/**
	 * @return the second
	 */
	public U getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(U second) {
		this.second = second;
	}

}
