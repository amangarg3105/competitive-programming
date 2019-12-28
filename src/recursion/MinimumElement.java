package recursion;

public class MinimumElement {

	public static int min(int [] a, int n) {
		if(n == 1) {
			return a[0];
		}
		
		int remainingMin = min(a, n - 1);
		
		int ans = Math.min(a[n-1], remainingMin);
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		int a[] = {5, 2, 6 ,8 ,1};
		
		int min = min(a, a.length);
		
		System.out.println(min);

	}

}
