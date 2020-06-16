package ex01;

import java.util.Scanner;

public class Equation {
	private Scanner sc = new Scanner(System.in);
	// private long a = 0, b = 0;

	public static void main(String[] args) {
		long a = 0, b = 0;
		Equation demo = new Equation();

		a = demo.input();
		b = demo.input();
		System.out.println(a + " " + b);

		demo.resolve(a, b);
	}

	// input
	private long input() {
		boolean check = false;
		long param = 0;
		while (!check)
			try {
				System.out.println("Enter paramater ");
				param = Long.parseLong(sc.next());
				check = true;
				return param;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return 0;
	}

	// resolve exercise
	private long resolve(long a, long b) {
		long result = 0;
		try {
			result = -b / a;
		} catch (ArithmeticException e) {
			System.out.println("a param shouldn't be 0");
			do {
				a = input();
			} while (a == 0);
			result = -b / a;
		}
		System.out.printf("%d","the result is: "+ result);
		return result;
	}

}
