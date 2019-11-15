package basics;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prev = 1;
		//This loop prints the lne
		for (int line = 1; line <= n; line++) {
			
			for(int space = 0; space <=  n - line; space++) {
				System.out.print(" ");
			}
			
			//This loop is responsible for printing numbers in a line.
			for(int j = 1; j <= line; j++) {
				if(j == 1 || j == line) {
					prev = 1;
				} else {
					prev = prev * (line - j + 1);
					prev = prev / (j - 1);
				}
				System.out.print(prev + "  ");
			}
			System.out.println();
		}

	}

}
