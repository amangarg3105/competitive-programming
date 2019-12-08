package strings;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LongestSubstring {

	/*
	 * Initialize Two pointers start, current
	 * 
	 * start = 0; current = 0; String output = ""; run a loop over the given string
	 * 
	 * if(output does not contains(current Character))
	 * 
	 * if(previousOuput < currentOutPut) add it in currentOutput in output
	 * 
	 * 
	 * else
	 * 
	 * increment the start
	 * 
	 * 
	 * return output;
	 */

	public static String longestSubstringWithUniqueCharacters(String s) {

		int startIndex = 0;
		int curretIndex = 0;
		String output = "";
		HashSet<Character> set = new LinkedHashSet<Character>();

		// set.add('a');
		// set.add('b');
		// set.add('a');
		//
		// for (Character c : set) {
		// System.out.println(c);
		// }
		while (curretIndex < s.length()) {
			if (!set.contains(s.charAt(curretIndex))) {
				set.add(s.charAt(curretIndex));
				String temp = s.substring(startIndex, startIndex + set.size());
				if (temp.length() > output.length()) {
					output = temp;
				}
				curretIndex++;
			} else {
				set.remove(s.charAt(startIndex));
				startIndex++;
			}

		}
		return output;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubstringWithUniqueCharacters("abdefgdagda"));
	}

}
