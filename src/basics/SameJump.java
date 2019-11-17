package basics;

public class SameJump {
	
	public static void main(String[] args) {
		int x1 =  6;
		
		int x2 = 8;
		
		int v1 = 3;
		
		int v2 = 2;
		
		if(x1  > x2 && v1 > v2) {
			System.out.println("No");
		}
		
		if(x2 > x1 && v2 > v1) {
			System.out.println("No");
		}
			
		
		if(((x1 - x2) % (v1 - v2) == 0)) 
			System.out.println("YES");
		else {
			System.out.println("NO");
		}
		
	}
}
