package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintKeyPadCombination {

	public static List<String> pirntkeypad(String s) {
		if (s.length() == 0) {
			String o = "";
			List<String> temp = new ArrayList<String>();
			temp.add(o);
			return temp;
		}

		List<String> ans = pirntkeypad(s.substring(1));
		String value = getValue(s.charAt(0));
		List<String> outputs = new ArrayList<String>();
		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < value.length(); j++) {
				String output = value.charAt(j) + ans.get(i);
				outputs.add(output);
			}
		}
		return outputs;
	}

	/*
	 * 
	 */
	
	/*
	 * 8826182658, 989778, 12345678580
	 * 
	 *  %583%
	 */

	public static String getValue(char c) {
		if (c == '2') {
			return "abc";
		} else if (c == '3') {
			return "def";
		}
		return null;
	}

	public static void main(String[] args) {
		List<String> ans = pirntkeypad("23");
		for(String s  : ans ) {
			System.out.println(s);
		}

	}

}
