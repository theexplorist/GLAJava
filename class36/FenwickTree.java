package class36;

import java.util.Arrays;

public class FenwickTree {

	private static void update(int index, int val, int[] fenw) {
		// TODO Auto-generated method stub

		while (index < fenw.length) {// 8 < 12
			fenw[index] += val;
			int l = intervalLength(index);
			index = index + l;
		}
	}

	// sum from index 1 to i
	private static int querySum(int[] fenw, int index) {// index - 1 to 7
		// TODO Auto-generated method stub

		int sum = 0;

		while (index > 0) {

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

//		int[] arr = { 0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
//
//		int[] fenw = new int[12];// all 0
//
//		for (int i = 1; i < arr.length; i++) {
//			update(i, arr[i], fenw);// i = 1, val = 3
//		}
//
//		System.out.println(Arrays.toString(fenw));
//		System.out.println(querySum(fenw, 7));
		
		int[] arr = {2, 3, 8, 6, 1000000};
		int maxV = Integer.MIN_VALUE;
		for(int e : arr) {
			maxV = Math.max(maxV, e);
		}
		
		int[] fen = new int[maxV + 1];
		int ct = 0;
		for(int i = 0; i < arr.length; i++) {
			int ce = arr[i];
			int s1 = querySum(fen, maxV);
			int s2 = querySum(fen, ce);
			
			ct = ct + (s1 - s2);
			update(ce, 1, fen);
		}
		System.out.println(Arrays.toString(fen));
		System.out.println(ct);
	}

}
