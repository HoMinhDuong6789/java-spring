package com.hmd;

public class Store<U extends Car> {
	//public class Store<U extends Number & Car> {
	U val1;

	public Store(U val1) {
		this.val1 = val1;

	}

	public U getVal1() {
		return val1;
	}

	public void setVal1(U val1) {
		this.val1 = val1;
	}

}
