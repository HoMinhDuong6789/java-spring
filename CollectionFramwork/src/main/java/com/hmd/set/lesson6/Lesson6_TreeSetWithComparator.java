package com.hmd.set.lesson6;

import java.util.Comparator;
import java.util.TreeSet;

public class Lesson6_TreeSetWithComparator {

	public static void main(String[] args) {
		var comparator = new Comparator<Car>() {
			public int compare(Car o1, Car o2) {
				if (o1.price > o2.price) {
					return 1;
				} else if (o1.price == o2.price) {
					return 0;
				} else {
					return -1;
				}
			};
		};

		// var carTreeSet = new TreeSet<Car>(comparator);
		var carTreeSet = new TreeSet<Car>((o1, o2) -> {
			if (o1.price > o2.price) {
				return 1;
			} else if (o1.price == o2.price) {
				return 0;
			} else {
				return -1;
			}
		});
		carTreeSet.add(new Car("Ferrari", 10000));
		carTreeSet.add(new Car("Ford", 3300));
		carTreeSet.add(new Car("Civid", 4000));
		carTreeSet.add(new Car("VinFast", 50000));

		System.out.println(carTreeSet);
	}
}
