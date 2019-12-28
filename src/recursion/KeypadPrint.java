package recursion;

public class KeypadPrint {

	
	public static void printKeyPad(String s, String output) {
		
		if(s.length() == 0) {
			System.out.println(output);
			return;
		}
		
	    String value = getValue(s.charAt(0));
	    
	    for(int i = 0; i < value.length(); i++) {
	    	
	   	 printKeyPad(s.substring(1), output + value.charAt(i));
	    	
	    }
		
	}
	
	
	public static String getValue(char c) {
		if(c == '2') {
			return "abc";
		} else if( c == '3'){
			return "def";
		}
		return null;
	}
	
	public static void main(String[] args) {
	
		printKeyPad("2323", "");

	}

}
