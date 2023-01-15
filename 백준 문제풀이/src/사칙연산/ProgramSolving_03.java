package 사칙연산;

import java.io.IOException;
import java.util.Scanner;

public class ProgramSolving_03 {

	public static void main(String[] args) {
		int a;
		int b;

		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		int result = (a - b);
		System.out.println(result);
	}

}
