package com.gurubelli.surya.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ClientSideLocking<E> {

	public List<E> list = Collections.synchronizedList(new ArrayList<E>());
	
	 /*---> Adding functionality to the existing Thread Safe classes
	 * --> 1. Adding new atomic operation is to modify the original class to support the desired operation 
	 * 2. Extending the class  ..if the underlying class were to change ..its synchronization policy by choosing different
	 * lock to guard its state variables , the subclass would subtly and silently break, because it no longer 
	 * used the right lock to control concurrent access to the base class's state.
	 * 3.  Client side locking :  More fragile because it entails putting locking code for class C into classes that are totally
	 * unrelated to C
	 * 4. Composition : 
	 */

	public boolean putIfAbsent(E x) {

		synchronized (list) {
			boolean absent = !list.contains(x);
			if (absent) {
				list.add(x);

			}
			return absent;

		}

	}

}
//Composition : : By delegating them to underlying list 
class ImprovedList<T> implements List<T> {

	private final List<T> list;
	
	public synchronized boolean putIfAbsent(T x) {
		 boolean contains = list.contains(x);
		 if (!contains) {
			 list.add(x);
		 }
		 
		 return !contains;
		 
		
	}
	
	public ImprovedList(List<T> list) {
		this.list = list;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}