package com.hmd.chapter2.lesson11;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		var values = new Integer[] {34,54,367};

		var store = new Store(values);
		
		System.out.println(store.get(1));
		
	}
}
