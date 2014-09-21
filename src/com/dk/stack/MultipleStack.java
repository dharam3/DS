package com.dk.stack;

import java.util.ArrayList;
import java.util.Stack;


public class MultipleStack<E> {
	
	private ArrayList<Stack> stacks= new ArrayList<>();
	
	
	public void push(E e){
		handleNoStackCase();
//		Stack s= ;
//		if(s.)
//		
	}
	
//	public E pop(){
	
//		return E;
//	}
	
	private void handleNoStackCase(){
		if(stacks.isEmpty()){
			Stack<E> stack= new Stack<>();
			stacks.add(stack);
		}
	}
	
	private Stack getLastStack(){
		return stacks.get(stacks.size());
	}
}
