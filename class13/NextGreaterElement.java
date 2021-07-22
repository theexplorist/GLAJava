package class13;

import java.util.Stack;

public class NextGreaterElement {

	//previous greater element -> same as stock span
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {31, 14, 15, 20};
		int days = 4;
		
		int[] nge = new int[days];
//		span[0] = 1;
		
		Stack<Integer> st = new Stack<>();
		
		st.push(0);
		
		for(int curr = 1; curr < days; curr++) {
			
			//jb tk prev greater element ni milta tb tk varna stack se break out
			while(!st.isEmpty() && prices[curr] > prices[st.peek()]) {
				nge[st.pop()] = prices[curr];
				//System.out.println(prices[st.pop()] + "->" + prices[curr]);
			}
				
			//span[curr] =  st.isEmpty() ?  curr + 1: curr - st.peek();
			st.push(curr);
		}
		
		while(!st.isEmpty()) {
			nge[st.pop()] = -1;
			//System.out.println(prices[st.pop()] + "->" + -1);
		}
		for(int i = 0; i < days; i++) {
			System.out.println(prices[i] + "->" + nge[i]);
		}
	}

}
