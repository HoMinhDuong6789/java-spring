package com.hmd.chapter2.lesson11;

public class Store<T> implements Operation<Integer> {

	Integer[] values;

	public Store(Integer[] values) {
		super();
		this.values = values;
	}

	@Override
	public T get(int position) {
		return values[position];
	}

	@Override
	public void replace(int position, T value) {
		values[position] = value;

	}

}
