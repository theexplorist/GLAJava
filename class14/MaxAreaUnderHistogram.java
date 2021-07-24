package class14;

import java.util.Stack;

public class MaxAreaUnderHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 6, 2, 3 };
		int n = 6;

		Stack<Integer> st = new Stack<>();

		st.push(0); // 1 value

		int[] nse = new int[n];
		for (int curr = 1; curr < arr.length; curr++) {

			while (!st.isEmpty() && arr[st.peek()] > arr[curr]) {
				nse[st.pop()] = curr;
			}

			st.push(curr);
		}

		while (!st.isEmpty()) {
			nse[st.pop()] = n;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + "->" + nse[i]);
		}
		
		st = new Stack<>();

		st.push(0); // 1 value

		int[] pse = new int[n];
		
		pse[0] = -1;
		
		for(int curr = 1; curr < n; curr++) {
			
			while(!st.isEmpty() && arr[st.peek()] >= arr[curr]) {
				st.pop();
			}
			
			if(!st.isEmpty()) {
				pse[curr] = st.peek();
			} else {
				pse[curr] = -1;
			}
			
			st.push(curr);
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i] + "->" + pse[i]);
		}
		
		int maxArea = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			int width = nse[i] - pse[i] - 1;
			int height = arr[i];
			
			int area = width * height;
			
			maxArea = Math.max(area, maxArea);
		}
		
		System.out.println(maxArea);
	}

}
