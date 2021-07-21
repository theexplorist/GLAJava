package class12;

import java.util.Stack;

public class StockSpanUsingStack {

	//prev greater element
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {10, 20, 30, 40};
		int days = 4;
		
		int[] span = new int[days];
		span[0] = 1;
		
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		
		for(int curr = 1; curr < days; curr++) {
			
			//jb tk prev greater element ni milta tb tk varna stack se break out
			while(!st.isEmpty() && prices[curr] > prices[st.peek()]) {
				st.pop();
			}
				
			span[curr] =  st.isEmpty() ?  curr + 1: curr - st.peek();
			st.push(curr);
		}
		
		for(int val : span) {
			System.out.print(val + " ");
		}
	}

}
