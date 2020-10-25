package com.hmd.chapter2.lesson12;

public class Store<T> {
	T values;

	public Store(T values) {
		super();
		this.values = values;
	}

	public T getValues() {
		return values;
	}

	public void setValues(T values) {
		this.values = values;
	}

}
