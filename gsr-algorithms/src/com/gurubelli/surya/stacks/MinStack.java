package com.gurubelli.surya.stacks;

import java.util.Iterator;

public class MinStack<Integer> implements Iterable<Integer>{

	int N ;
	NodeWithMin first;
	
	private class NodeWithMin { 
		Integer item;
		Integer min;
		
	}

	@Override
	public Iterator<Integer> iterator() { 
		return null;
	}
	
}
