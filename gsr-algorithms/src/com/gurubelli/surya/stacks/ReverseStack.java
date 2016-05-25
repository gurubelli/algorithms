package com.gurubelli.surya.stacks;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {

		Stack<Integer> myStack = new Stack<>();
		myStack.push(new Integer(1));
		myStack.push(new Integer(2));
		myStack.push(new Integer(3));

		System.out.println("Original Stack" + myStack);
		reverseStackR(myStack);
		
		System.out.println("Reversed stack" + myStack);
	}

	private static void reverseStackR(Stack<Integer> myStack) {

		Integer element = myStack.pop();
		if (myStack.size() !=1) {
			reverseStackR(myStack);
		}
		//else pushto bottom
		pushToBottomOfStack(element, myStack);
	}
	
	private static void pushToBottomOfStack(Integer data, Stack<Integer> stack) {
		Integer element = stack.pop();
		if (stack.size() != 0) {
			pushToBottomOfStack(data, stack);
		} else {
			stack.push(data);
		}
		stack.push(element);
	}
}
