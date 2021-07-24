package class15;

import java.util.HashMap;
import java.util.Map;

public class MiscMapFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//getOrDefault
		
		Map<String, Integer> freqMap = new HashMap<>();
		System.out.println(freqMap.get("USA"));
		
		if (freqMap.containsKey("USA")) {
			System.out.println(freqMap.get("USA"));
		} else {
			System.out.println("USA to hai hi ni!");
		}
		
		System.out.println(freqMap.getOrDefault("USA", 0));
		
		freqMap.put("USA", 100);
		System.out.println(freqMap.getOrDefault("USA", 0));
		freqMap.put("USA", 200);
		
		System.out.println(freqMap.get("USA"));//200
		//putIfAbsent
		freqMap.putIfAbsent("USA", 300);
		System.out.println(freqMap.get("USA"));//200
	}

}
