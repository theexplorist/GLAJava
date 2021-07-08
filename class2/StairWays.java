package class2;

public class StairWays {

	private static int sol(int n) {
		// TODO Auto-generated method stub
		
		if(n == 0 || n == 1) {
			return 1;
		}
		int c1 = sol(n - 1);
		int c2 = sol(n - 2);
		
		int totalWays = c1 + c2;
		return totalWays;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sol(2));
	}

}
