package class10;

public class EditDistance {

	private static int sol(String s1, String s2, int n, int m) {
		// TODO Auto-generated method stub

		if(n == 0 && m == 0) {
			return 0;
		}
		
		if(n == 0) {
			return m;
		}
		
		if(m == 0) {
			return n;
		}
		
		if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return sol(s1, s2, n - 1, m - 1);
		} 
		
		int ins = sol(s1, s2, n, m - 1);
		int rep = sol(s1, s2, n - 1, m - 1);
		int del = sol(s1, s2, n - 1, m);
		
		return 1 + Math.min(ins, Math.min(rep, del));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sol("intention", "execution", 9, 9));
	}

}
