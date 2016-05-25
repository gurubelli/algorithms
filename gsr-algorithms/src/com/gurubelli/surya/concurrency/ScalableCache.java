package com.gurubelli.surya.concurrency;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ScalableCache {

}

interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction<A, V> implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		// TODO Auto-generated method stub
		return new BigInteger(arg);
	}

}
/**
 * Usring conventional HashMap
 * @author esrigur
 *
 * @param <A>
 * @param <V>
 */
class Memorizer1<A, V> implements Computable<A, V> {
	private final Map<A, V> cache = new HashMap<A, V>();
	private final Computable<A, V> c;

	public Memorizer1(Computable<A, V> c) {
		this.c = c;
	}

	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;

	}

}
/**
 * Replace HashMap with ConcurrentHashMap
 * @author esrigur
 *
 * @param <A>
 * @param <V>
 */
class Memorizer2<A, V> implements Computable<A, V> {
	private final ConcurrentMap<A, V> cache = new ConcurrentHashMap<A, V>();
	private final Computable<A, V> c;

	public Memorizer2(Computable<A, V> c) {
		this.c = c;
	}

	public  V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		//Still has window of vulnerablity 
		//One thread starts starts an expensive computation other threads may not be aware of that 
		//so this might start computation ..
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;

	}
  //Entire function is blocked
}

/**
 * Replace HashMap with ConcurrentHashMap and future task
 * @author esrigur
 *
 * @param <A>
 * @param <V>
 */
class Memorizer3<A, V> implements Computable<A, V> {
	private final ConcurrentMap<A, Future<V>>cache = new ConcurrentHashMap<>();
	private final Computable<A, V> c;

	public Memorizer3(Computable<A, V> c) {
		this.c = c;
	}

	public  V compute(final A arg) throws InterruptedException {
		Future<V> f = cache.get(arg);
		if (f == null) {
			Callable<V> eval = new Callable<V>() {

				@Override
				public V call() throws Exception {
					// TODO Auto-generated method stub
					return c.compute(arg);
				}
				
			};
			FutureTask<V> ft = new FutureTask<>(eval);
			f = cache.putIfAbsent(arg,ft);;
			if ( f == null) {
				f = ft ; 
			}
		}
		
			try {
				return f.get();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				return null;
			}
		

	}
  //Entire function is blocked
}
