package 조건문;

import java.io.IOException;
import java.util.Scanner;

public class ProgramSolving_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A > 0 && A != 0 && B > 0 && B != 0) {
			System.out.println("1");
		} else if (A < 0 && A != 0 && B > 0 && B != 0) {
			System.out.println("2");
		} else if (A < 0 && A != 0 && B < 0 && B != 0) {
			System.out.println("3");
		} else if (A > 0 && A != 0 && B < 0 && B != 0) {
			System.out.println("4");
		}
	}

}
