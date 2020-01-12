package maps;

import java.util.HashMap;
import java.util.Scanner;


/*
 * 1. Count the distinct characters in the original string
 * 
 * var startOfWindow = 0
 * 
 * 2. Iterate over the original string
 * 
 * 2.1 Count the current character occurrence
 * 
 * 2.2 If this current character occurrence is 1 tempCount++;
 * 
 * 2.3 if(distinctCount == tempCount)
 * 
 * 
 * while(Character at StartOfWindow's count > 1)
 * 
 * remove StartOfWindow'sCharacter from this current window
 * 
 * Increament the StartOfWindow;
 * 
 * 
 * 2.4 . calculate the current window size
 * 
 * 2.5 . if currentWindow size < smallestWindow
 * 
 * smallestWindow = currentWindow
 * 
 * 
 * 
 * 
 * print the smallest window.
 */
public class SmallestSubStringDistinctCharacter {


	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		// get the input string
		String str = in.nextLine();
		int n = str.length();

		// possible number of characters

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int distinctCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				distinctCount++;
				map.put(str.charAt(i), 1);
			}
		}


		int startOfSmallestWindow = -1;

		int startOfCurrentWindow = 0;

		int tempCount = 0;

		int minimumLenWindow = Integer.MAX_VALUE;

		map = new HashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				tempCount++;
				map.put(str.charAt(i), 1);
			}


			if (distinctCount == tempCount) {
				while (map.get(str.charAt(startOfCurrentWindow)) > 1) {
					if (map.get(str.charAt(startOfCurrentWindow)) > 1) {
						map.put(str.charAt(startOfCurrentWindow), map.get(str.charAt(startOfCurrentWindow)) - 1);
					}
					startOfCurrentWindow++;
				}

				int currentWindowSize = i - startOfCurrentWindow + 1;

				if (currentWindowSize < minimumLenWindow) {
					minimumLenWindow = currentWindowSize;
					startOfSmallestWindow = startOfCurrentWindow;
				}
			}
		}

		System.out.println(str.substring(startOfSmallestWindow, startOfSmallestWindow + minimumLenWindow));

	}
}
