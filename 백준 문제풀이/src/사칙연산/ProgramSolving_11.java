package 사칙연산;

import java.io.IOException;
import java.util.Scanner;

public class ProgramSolving_11 {

	public static void main(String[] args) {
		int A;
		int B;

		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();

		int result = A * B;

		for (int i = 0; i <= (int) (Math.log10(B) + 1); i++) {
			int temp = B % 10;
			B /= 10;
			System.out.println(temp * A);
		}
		System.out.println(A * B);
		System.out.println(result);

	}

}
