package com.hmd.arraylist;

import java.util.Arrays;

public class Lesson8_UsingIterators {
	public static void main(String[] args) {

		var list = Arrays.asList(4, 8, 2, 5, 88, 16);
		/*
		 * var iterate = list.iterator();
		 * 
		 * while (iterate.hasNext()) { // hasNext(): return true if the iteration has
		 * more element System.out.println("Has next......"+ iterate.next()); }
		 */

		var iterate = list.listIterator();
		while (iterate.hasPrevious()) { // hasPrevious(): It can also move backwards
			System.out.println("Has next......" + iterate.previous());
		}
	}
}
