package class38;

import java.util.Arrays;

public class SieveOfEratosthenes {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 25;
		boolean[] primes = new boolean[n + 1];
		
		Arrays.fill(primes, true);
		
		primes[0] = primes[1] = false;
		for(int curr = 2; curr * curr <= n; curr++) {
			if(primes[curr] == true) {//curr = 5
				//curr ke saare multiples ko cancel krdo, yaani false krdo, yaani not prime
				for(int i = curr * 2; i <= n; i = i + curr) {
					primes[i] = false;
				}
			}
		}
		
		for(int i = 2; i <= n; i++) {
			if(primes[i]) {
				System.out.println(i);
			}
		}
	}

}
