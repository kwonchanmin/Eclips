package 조건문;

import java.io.IOException;
import java.util.Scanner;

public class ProgramSolving_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();

		if (M < 45 && H != 0) {
			H = H - 1;
			M = M - 45 + 60;
			System.out.println(H + " " + M);
		} else if (M < 45 && H == 0) {
			H = 23;
			M = M - 45 + 60;
			System.out.print(H + " " + M);
		} else if (M > 45) {
			M = M - 45;
			System.out.print(H + " " + M);
		} else if (M == 45) {
			M = 0;
			System.out.print(H + " " + M);
		}

	}

}
