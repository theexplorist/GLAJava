package class17;

import java.util.Arrays;

public class BinarySearchUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 2, 5, 7};
		
		int search = 4;
		
		
		int idx = Arrays.binarySearch(arr, search);
		//if elem not present 
		// immediate smaller -> |idx| - 2 L.B
		//immediate greater -> |idx| - 1 U.B
		if(idx < 0) {
			idx = Math.abs(idx) - 2; //Lower bound
		}
		
		System.out.println(arr[idx]);
	}

}
