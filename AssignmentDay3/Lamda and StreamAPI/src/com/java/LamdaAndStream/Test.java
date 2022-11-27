package com.java.LamdaAndStream;

//Java program to demonstrate lambda expressions to
//implement a user defined functional interface.

@FunctionalInterface
interface Multiply {
	int calculate(int x,int y);
}

class Test {
	public static void main(String args[])
	{
		int a = 5;
		int b=10;

		// lambda expression to define the calculate method
		Multiply m = (int x,int y) -> x * y;

		// parameter passed and return type must be
		// same as defined in the prototype
		int ans = m.calculate(a,b);
		System.out.println(ans);
	}
}

