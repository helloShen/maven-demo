/**
 * Maven Demo
 */
package com.ciaoshen.maven.demo;
import java.util.Random;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }
    public static int minus(int a, int b) {
		return a - b;
	}
	public static int multiply(int a, int b) {
		return a * b;
	}
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Dividor can not be 0! Your param a = " + a + ", b = " + b);
        }
		return a / b;
	}

    // traditional unit test
    private static void test(int a, int b) {
        System.out.println(a + " + " + b + " = " + add(a,b) + "\t[answer=" + (a + b) + "]");
        System.out.println(a + " - " + b + " = " + minus(a,b) + "\t[answer=" + (a - b) + "]");
        System.out.println(a + " * " + b + " = " + multiply(a,b) + "\t[answer=" + (a * b) + "]");
        int quotient = divide(a,b);
        if (b != 0) {
            System.out.println(a + " / " + b + " = " + divide(a,b) + "\t[answer=" + (a / b) + "]");
        } else {
            System.out.println(a + " / " + b + " = " + divide(a,b) + "\t[ERR: should throw IllegalArgumentException!]");
        }
    }

    public static void main(String[] args) {
        int max = 1000;
        Random r = new Random();
        test(r.nextInt(max), r.nextInt(max) + 1);
    }
}
