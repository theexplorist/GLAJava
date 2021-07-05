package class1;

public class PrintIncreasing {

	private static void printInc(int n) {
		if(n == 0) {
			return;
		}
		
		printInc(n - 1);
		System.out.println(n);
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printInc(5);
	}

}
