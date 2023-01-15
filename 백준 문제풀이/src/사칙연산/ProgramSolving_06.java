package 사칙연산;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ProgramSolving_06 {

	public static void main(String[] args) {
		int a;
		int b;

		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		int c = (a + b);
		int d = (a - b);
		int e = (a * b);
		int f = (a / b);
		int g = (a % b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);

	}

}
