package class14;

import java.util.Stack;

public class PreviousSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 5, 6, 2, 3, 0};

		int n = 6;

		Stack<Integer> st = new Stack<>();

		st.push(0); // 1 value

		int[] pse = new int[n];
		
		pse[0] = -1;
		
		for(int curr = 1; curr < n; curr++) {
			
			while(!st.isEmpty() && arr[st.peek()] >= arr[curr]) {
				st.pop();
			}
			
			if(!st.isEmpty()) {
				pse[curr] = arr[st.peek()];
			} else {
				pse[curr] = -1;
			}
			
			st.push(curr);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + "->" + pse[i]);
		}
	}

}
