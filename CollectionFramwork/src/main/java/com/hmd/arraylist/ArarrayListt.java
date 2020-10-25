package com.hmd.arraylist;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class ArarrayListt {
	public static void main(String[] args) {
		var list = new ArrayList<Integer>();
		list.add(23);
		list.add(25);
		list.add(26);
		list.add(29);
		list.add(32);
		list.add(35);
		list.add(56);

		// remove ,method
		list.remove(Integer.valueOf(23));

		// update
		list.set(1, 522);

		// addAll
		var listS = new ArrayList<Integer>();
		listS.add(123);
		listS.add(113);
		listS.add(133);

		list.addAll(listS);

		// removeIf
		// list.removeIf(integer-> true);
		// predicate, if return value is true, that it removes that element
		//list.removeIf(integer -> integer % 2 == 0);

		// clear
		//list.clear();
		
		//contain
		 var result = list.contains(113);
		 System.out.println(result);

		System.out.println(list);
	}
}
