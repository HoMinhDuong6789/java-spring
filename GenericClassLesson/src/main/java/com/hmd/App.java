package com.hmd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       var countries = new String[] {"Vietnam", "Thailand", "Compudia"};
       var names = new String[] {"John", "James", "Daniel"};
       var scores = new Integer[] {22, 46, 66,54};
       
       var store1 = new Store<>(countries);
       var store2 = new Store<>(names);
       var store3 = new Store<>(scores);
       
       store1.greaterThan(store2);
       
    }
}
