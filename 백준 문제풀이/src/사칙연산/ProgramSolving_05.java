package 사칙연산;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ProgramSolving_05 {

	public static void main(String[] args) {
		double a;
		double b;

		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		double result = (a / b);
		System.out.println(Double.valueOf(new DecimalFormat("#.################################").format(result)));
	}

}
