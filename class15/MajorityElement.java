package class15;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		
		int n = arr.length;
		Map<Integer, Integer> freqMap = new HashMap<>();
		
		
		for(int e : arr) {
			
			int value = freqMap.getOrDefault(e, 0);
			value++;
			freqMap.put(e, value);
//			if(freqMap.containsKey(e)) {
//				int value = freqMap.get(e);
//				value++;
//				freqMap.put(e, value);
//			} else {
//				freqMap.put(e, 1);
//			}
		}
		
		System.out.println(freqMap);
		
		int minVal =  n / 2;
		
		for(int key : freqMap.keySet()) {
			if(freqMap.get(key) > minVal) {
				System.out.println(key);
			}	
		}
		
		for(var entry : freqMap.entrySet()) {
			if(entry.getValue() > minVal)
			System.out.println(entry.getKey());
		}
	}

}
