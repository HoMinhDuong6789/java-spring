package com.hmd.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson7_ArrayListt {
	public static void main(String[] args) {
		var list = Arrays.asList(23, 22, 11, 545, 43, 67, 79);
		// Arrays: this class contains various methods for manipulating arrays (such as
		// sorting and searching)
		
		
		//list.add(424); //fixed
		//Arrays: whenever you use this method, you're creating a list that can not change immutable lists
		list =new ArrayList<>(Arrays.asList(23, 22, 11, 545, 43, 67, 79)) ;
		list.add(424);
		
		
		System.out.println(list);
	}
}
