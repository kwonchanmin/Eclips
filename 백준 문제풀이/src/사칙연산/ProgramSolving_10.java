package 사칙연산;

import java.io.IOException;
import java.util.Scanner;

public class ProgramSolving_10 {

	public static void main(String[] args) {
		int A;
		int B;
		int C;

		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		System.out.println((A + B) % C);
		System.out.println(((A % C) + (B % C)) % C);
		System.out.println((A * B) % C);
		System.out.println(((A % C) * (B % C)) % C);
	}

}
