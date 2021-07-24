package class14;

import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 5, 6, 2, 3};
		
		int n = 5;
		
		Stack<Integer> st = new Stack<>();
		
		st.push(0); //1 value
		
		int[] nse = new int[n];
		for(int curr = 1; curr < arr.length; curr++) {
			
			while(!st.isEmpty() && arr[st.peek()] > arr[curr]) {
				nse[st.pop()] = arr[curr];
			}
			
			st.push(curr);
		}
		
		while(!st.isEmpty()) {
			nse[st.pop()] = -1;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + "->" + nse[i]);
		}
		
		System.out.println(st.isEmpty());
	}

}
