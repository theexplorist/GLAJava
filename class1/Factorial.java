package class1;

public class Factorial {

	private static void fact2(int n, int ans) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			System.out.println(ans);
			return;
		}
		fact2(n - 1, ans * n);
	}
	private static int fact(int n) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {//1
			return 1;
		}
		
		
		int recAns = fact(n - 1);//2
		int meraAns = n * recAns;//3
		
		return meraAns;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fact2(4, 1);
	}

}
