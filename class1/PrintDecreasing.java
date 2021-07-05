package class1;

public class PrintDecreasing {

	private static void printDec(int n) {
		if(n == 0) {
			return;
		}
		System.out.println(n);
		printDec(n - 1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDec(5);
	}

}
