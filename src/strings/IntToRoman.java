package strings;

import java.util.Scanner;

public class IntToRoman {


	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		romanNumeral(n);
	}


	/*
	 * Time Complexity - o(1)
	 * 
	 * Space Complexity - o(1)
	 */
	static void romanNumeral(int num) {
		
		
		String ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};


		String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};


		String hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};


		String thousands[] = {"", "M", "MM", "MMM"};


		System.out.print(thousands[num / 1000]);

		System.out.print(hundreds[(num % 1000) / 100]);

		System.out.print(tens[(num % 100) / 10]);

		System.out.print(ones[num % 10]);
	}
}
