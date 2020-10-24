package com.hmd.chapter2.lesson11;

public interface Operation<T> {
	T get(int position);

	void replace(int position, T value);
}
