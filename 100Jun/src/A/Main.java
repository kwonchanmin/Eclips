package A;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (B + C < 60) {
			B = B + C;
			System.out.println(A + " " + B);
		} else if (A == 23 && B + C >= 60) {
			A = 0;
			B = B + (60 -C);
			System.out.println(A + " " + B);
		} else if (B + C >= 60 && B + C < 120) {
			A = A + 1;
			B = B + (60 - C);
			if(A>23) {
				A=0;
				System.out.println(A + " " + B);
			}
		} else if (B + C >= 120 && B + C < 180) {
			A = A + 2;
			B = B + (180-C);
			if(A>23) {
				A=0;
				B = B + (180 - C);
				System.out.println(A + " " + B);
			}
//		}else if (B + C >= 180 && B + C < 240) {
//			A = A + 3;
//			B = B + (C - 180);
//			System.out.println(A + " " + B);
		}
//		}else if (B + C >= 240 && B + C < 300) {
//			A = A + 4;
//			B = B + (C - 240);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 300 && B + C < 360) {
//			A = A + 5;
//			B = B + (C - 300);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 360 && B + C < 420) {
//			A = A + 6;
//			B = B + (C - 360);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 420 && B + C < 480) {
//			A = A + 7;
//			B = B + (C - 420);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 480 && B + C < 540) {
//			A = A + 8;
//			B = B + (C - 480);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 540 && B + C < 600) {
//			A = A + 9;
//			B = B + (C - 540);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 600 && B + C < 660) {
//			A = A + 10;
//			B = B + (C - 600);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 660 && B + C < 720) {
//			A = A +11;
//			B = B + (C - 660);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 720 && B + C < 780) {
//			A = A +12;
//			B = B + (C - 720);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 780 && B + C < 840) {
//			A = A + 13;
//			B = B + (C - 780);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 840 && B + C < 900) {
//			A = A + 14;
//			B = B + (C - 840);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 900 && B + C < 960) {
//			A = A + 15;
//			B = B + (C - 900);
//			System.out.println(A + " " + B);
//		}else if (B + C >= 960 && B + C <= 1000) {
//			A = A + 16;
//			B = B + (C - 960);
//			System.out.println(A + " " + B);
//		}
	}

}
