package com.hmd.set;

import java.util.HashSet;

public class Lesson1_HashSet {

	public static void main(String[] args) {
		var hashSet = new HashSet<Integer>();

		hashSet.add(12);
		hashSet.add(126);
		hashSet.add(24);
		hashSet.add(22);
		hashSet.add(32);

		System.out.println(hashSet);

		// HashSet Capacity and LoadFactory
		var hashSett = new HashSet<Integer>(5, 0.75f);
		/*
		 * default initial capacity of the Hash Map takes is 16 and factory is 0.75f,
		 * (i.e 57% current hashmap size
		 * 
		 *	The load factory represents ad what level the HashMap capacity should be double 
		 */
	}
}
