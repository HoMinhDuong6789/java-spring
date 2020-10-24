package com.hmd;

public class Store {
	
	public <T> Store(T value){
		System.out.println("Starting....."+ value);
	}
	
	public void open () {
		System.out.println("Open.........");
	}
	
	public <T>void print (T num) {
		 System.out.println(num);
	}
	
}
