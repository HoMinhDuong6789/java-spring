package com.hmd;

public class Store {
	Object value;

	public Store(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void valueClass() {
		System.out.println(value.getClass());
	}

}
