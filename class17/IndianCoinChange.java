package class17;

import java.util.Arrays;

public class IndianCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] currency = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		
		int amount = 39;
		
		int count = 0;
		while(amount > 0) {
			int indx = Arrays.binarySearch(currency, amount);
			
			if(indx < 0) {
				
				//immediate chota
				indx = Math.abs(indx) - 2;
			}
			
			//System.out.print(currency[indx] + "+");
			amount = amount - currency[indx];
			count++;
		}
		
		System.out.println(count);
	}

}
