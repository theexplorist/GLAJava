package class2;

public class FibonacciNumber {

	private static int sol(int n) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			return n;
		}
		
		int c1 = sol(n - 1);
		int c2 = sol(n - 2);
		
		int meraAnswer = c1 + c2;
		return meraAnswer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sol(4));
	}

}
