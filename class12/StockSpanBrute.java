package class12;

public class StockSpanBrute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {31, 27, 14, 21, 30, 22};
		int days = 6;
		
		int[] span = new int[days];
		span[0] = 1;
		
		for(int curr = 1; curr < days; curr++) {
			span[curr] = 1;
			
			for(int prev = curr - 1; prev >= 0; prev--) {
				if(prices[prev] < prices[curr]) {
					span[curr]++;
				} else {
					break; //prev greater element mila to break out
				}
			}
		}
		
		for(int val : span) {
			System.out.print(val + " ");
		}
		
	}

}
