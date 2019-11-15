package basics;
import java.util.Scanner;

public class NextLargestNumber {


	public static void main(String args[]) {
		String str;
		Scanner s = new Scanner(System.in);
		str = s.nextLine();
		nextLargestNumber(str);
		s.close();
	}


	static void nextLargestNumber(String str) {
		int n = str.length();
		
		StringBuilder s = new StringBuilder(str);
		
		int i = n - 1;
		
		while(i > 0 && s.charAt(i) <= s.charAt(i - 1)) {
			i--;
		}
		
		int firstCandidate = i - 1; 
		System.out.println("First Cndidate " +str.charAt(firstCandidate)); // First Candidate
		
		
		if(firstCandidate >=0 ) {
			int secondCandidate = i;
			i++;
			
			while(i < n && s.charAt(i) >  s.charAt(firstCandidate)) {
				if(s.charAt(i) <= s.charAt(secondCandidate)) {
					secondCandidate = i;
				}
				i++;
			}
			
			System.out.println("Second Candidate " +s.charAt(secondCandidate));
			
			swap(s, firstCandidate, secondCandidate);
			
			System.out.println(s.toString());
		}
		
		
	}


	private static void swap(StringBuilder s, int firstCandidate, int secondCandidate) {
		char temp = s.charAt(firstCandidate);
		s.setCharAt(firstCandidate, s.charAt(secondCandidate));
		s.setCharAt(secondCandidate, temp);	
		
	}
}
