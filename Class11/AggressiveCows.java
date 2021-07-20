package Class11;

import java.util.Arrays;

public class AggressiveCows {

	private static boolean isPlaced(int[] stalls, int cows, int mid) {
		// TODO Auto-generated method stub

		int placedPos = stalls[0];
		int numPlaced = 1;
		
		for(int stallNum = 1; stallNum < stalls.length; stallNum++) {
			
			if(numPlaced == cows) {
				return true;
			}
			int currStall = stalls[stallNum];
			if(currStall - placedPos >= mid) {
				numPlaced++;
				placedPos = currStall;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] stalls = {1, 2, 8, 4, 9};
		int n = 5, c = 3;
		Arrays.sort(stalls);
		System.out.println(Arrays.toString(stalls));
		int l = 0, r = stalls[n - 1] - stalls[0]; //r = 8
		
		while(r > l + 1) {
			int mid = l + (r - l) / 2; //kya main 3 cows ko mid distance pr place kr pa rahah hun?
			
			if(isPlaced(stalls, c, mid)) {
				l = mid;
			} else {
				r = mid;
			}
		}
		
		System.out.println(l);
	}

}
