package class7;

import java.util.Arrays;

public class FibonacciNumber {

	private static int sol(int n, int[] cache) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			return n;
		}
		
		
		if(cache[n] != -1) { // -1 -> pehlie baar
			return cache[n];
		}
		
		//pehli baar musibat ka saamna
		int c1 = sol(n - 1, cache);
		int c2 = sol(n - 2, cache);
		
		int meraAnswer = c1 + c2;
		cache[n] = meraAnswer;
		return meraAnswer; //experience store for future
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 40;
		int[] cache = new int[n + 1];
		Arrays.fill(cache, -1);
		System.out.println(sol(n, cache));
	}

}
