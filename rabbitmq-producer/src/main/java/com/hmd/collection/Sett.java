package com.hmd.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Sett {
	public static void main(String[] args) {
		HashMap<String, String> listMap = new HashMap<>();
		listMap.put("name", "Mitt");
		listMap.put("email", "minhsnsdsad@gmail.com");
		listMap.put("adress", "Nha Trang");
		listMap.put("phone", "09352222");

		// cah duyet casc ohan tu trong mang
		Set<String> keys = listMap.keySet();
		keys.forEach((key) -> {
			System.out.println("keys:\t" + key + "\t" + listMap.get(key));
		});
		System.out.println("=======================================");
		keys.forEach((t) -> {
			System.out.println("key: " + t + "\t:\t" + listMap.get(t));
		});

		// muc 2:
		TreeMap<String, Object> tree = new TreeMap<>();
		LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
		System.out.println("=======================================");
		// muc3: Stack anf Queues
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.offer("A1");
		queue.offer("A2");
		queue.offer("A3");
		queue.offer("A4");

		System.out.println(queue.poll());

	}
}
