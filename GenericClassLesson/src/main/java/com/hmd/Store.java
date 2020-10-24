package com.hmd;

public class Store<U> {
	U[] val1;

	public Store(U[] val1) {
		this.val1 = val1;

	}

	public void greaterThan(Store<U> otherStore) {
		//public void greaterThan(Store<?> otherStore) {
		if (val1.length > otherStore.val1.length) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
