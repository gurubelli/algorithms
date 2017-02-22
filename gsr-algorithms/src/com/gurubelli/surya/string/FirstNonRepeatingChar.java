package com.gurubelli.surya.string;

public class FirstNonRepeatingChar {

	// 4 ideas
	/*
	 * 1. LinkedHashMap and maintain count --> loop through count 2. Maintain
	 * two --> Repeated or non repeated (Set and ArrayList) 3. Maintain count
	 * array and loop on count array instead of on string double linkedlist +
	 * hashtable. hash table maps the character to its pointer in linked list.
	 * Pointer NULL means duplicate. When a character arrives, if it is in the
	 * hash table (pointer not NULL), remove it from the linkedist and reset the
	 * pointer, otherwise insert it into hash table and the tail of linked list.
	 * When answering an query, return the first character in the double linked
	 * list.
	 *
	 */
}
