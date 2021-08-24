package class35;

public class FenwickTree {

	private static void update(int index, int val, int[] fenw) {
		// TODO Auto-generated method stub

		while(index < fenw.length) {
			fenw[index] += val;
			int l = intervalLength(index);
			index = index + l;
		}
	}
	//sum from index 1 to i
	private static int querySum(int[] fenw, int index) {//index - 1 to 7
		// TODO Auto-generated method stub

		int sum = 0;
		
		while(index > 0) {
			
			sum += fenw[index];
			int l = index & -index;
			
			index = index - l;
		}
		
		return sum;
	}
	
	private static int intervalLength(int index) {
		// TODO Auto-generated method stub

		return index & -index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
		
		int[] fenw = new int[12];
		
		for(int i = 1; i < arr.length; i++) {
			update(i, arr[i], fenw);
		}
		//System.out.println(intervalLength(10));
		
		System.out.println(querySum(fenw, 7));
	}

}
