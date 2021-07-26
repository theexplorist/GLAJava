package Class16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOnePass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 11, 15, 7, 2 };
		int target = 14;
		// Hashmap key -> element, value -> corresponding index

		Map<Integer, Integer> map = new HashMap<>();
		
		
		//Searching
		for(int i = 0; i < arr.length; i++) {
			int searchInMap = target - arr[i]; //element as a key
			
			if(map.containsKey(searchInMap)) {
				int[] pair = new int[2];
				pair[0] = i;
				pair[1] = map.get(searchInMap); //index as a value
				System.out.println(Arrays.toString(pair));
				break;
			}
			
			map.put(arr[i], i);
		}
	}

}
