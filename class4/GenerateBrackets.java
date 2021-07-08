package class4;

public class GenerateBrackets {

	static int count = 0;
	private static void genB(String ans, int n, int oc, int cc) {
		// TODO Auto-generated method stub
		
		if(oc == n && cc == n) {
			count++;
			System.out.println(ans);
			return;
		}
		
		if(oc > cc) {
			genB(ans + ')', n, oc, cc + 1);
		}
		
		if(oc < n) {
			genB(ans + '(', n, oc + 1, cc);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = 2;
		
		while(t-- != 0) {
			count = 0;
			genB("", 3, 0, 0);
			System.out.println(count);
		}
		
	}

}
