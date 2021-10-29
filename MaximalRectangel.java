class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length == 0) {
            return 0;
        }
        int maxA = Integer.MIN_VALUE;
        int[] ht = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    ht[j] = ht[j] + 1;
                } else {
                    ht[j] = 0;
                }
              //  ht[j] = matrix[i][j] == 1 ? ht[j] + 1 : 0;
            }
            System.out.println(Arrays.toString(ht));
            maxA = Math.max(maxA, sol(ht, ht.length));
        }
        
        return maxA;
    }
    
    public int sol(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();

		int[] nse = new int[n];
		st.push(0);

		for (int curr = 1; curr < arr.length; curr++) {

			// is curr building nse of top building?
			while (!st.isEmpty() && arr[st.peek()] > arr[curr]) {
				nse[st.pop()] = curr;
				// System.out.println(st.pop() + "->" + arr[curr]);
			}

			st.push(curr);
		}

		while (!st.isEmpty()) {
			nse[st.pop()] = n;
			// System.out.println(st.pop() + "->" + -1);
		}

		
		int[] pse = new int[n];
		st.push(0); // height
		pse[0] = -1;
		// System.out.println(arr[0] + "->" + -1);
		for (int curr = 1; curr < n; curr++) {

			while (!st.isEmpty() && arr[curr] <= arr[st.peek()]) {

				st.pop();
			}

			if (!st.isEmpty()) {
				pse[curr] = st.peek();
			} else {
				pse[curr] = -1;
			}

			st.push(curr);
		}


		
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			//ith building width
			int width = nse[i] - pse[i] - 1;
			int area = width * arr[i];
			
			maxArea = Math.max(maxArea, area);
		}
		
        
        return maxArea;
    }
}

class Solution {
    public int validSubarrays(int[] ht) {
        
        Stack<Integer> st = new Stack<>();
		
		int[] nse = new int[ht.length];
		st.push(0);
		
		for(int curr = 1; curr < ht.length; curr++) {
			
			while(!st.isEmpty() && ht[st.peek()] > ht[curr]) {
				nse[st.pop()] = curr;
			}
			st.push(curr);
		}
		
		while(!st.isEmpty()) {
			nse[st.pop()] = ht.length;
			//System.out.println(st.pop() + " ka nge hai " + -1);
		}
		
		int ans = 0;
		for(int i = 0; i < ht.length; i++) {
			ans += (nse[i] - i);
		}
        
        return ans;
    }
}
