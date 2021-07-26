package Class16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

	private static int rev(int num) {
		// TODO Auto-generated method stub

		int revNum = 0;
		
		while(num > 0) {
			int digit = num % 10;
			num = num / 10;
			
			revNum = revNum * 10 + digit;
		}
		
		//System.out.println(revNum);
		
		return revNum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 42, 11, 1, 97, 97};
		
		// Hashmap key -> element, value -> corresponding index

		Map<Integer, Integer> map = new HashMap<>();
		
		int ans = 0;
		
		//Searching
		for(int i = 0; i < arr.length; i++) {
			int searchInMap = arr[i] - rev(arr[i]); //element as a key
			
			if(map.containsKey(searchInMap)) {
				ans += map.get(searchInMap);
			}
			
			map.put(searchInMap, map.getOrDefault(searchInMap, 0) + 1);
			
		}
		
		System.out.println(ans);
	}

}
