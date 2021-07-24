package class15;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// country - population
		Map<String, Integer> freqMap = new HashMap<>();

		freqMap.put("India", 10);
		freqMap.put("Australia", 5);
		freqMap.put("England", 4);

		System.out.println(freqMap);
		freqMap.put("India", 20);// update(key will be unique)
		System.out.println(freqMap);

		// what is the population of india?
		// get(key), key = "India"
		System.out.println(freqMap.get("India"));
		System.out.println(freqMap.get("USA"));// if key is not present then value hai that is null
		freqMap.put("USA", 6);
		System.out.println(freqMap.get("USA"));
		System.out.println(freqMap);

		if (freqMap.containsKey("Russia")) {
			System.out.println(freqMap.get("Russia"));
		} else {
			System.out.println("Russia to hai hi ni!");
		}

		System.out.println(freqMap.keySet());
		for(var entry : freqMap.entrySet()) {
			//System.out.println(entry);
			System.out.println("entry's key is : " + entry.getKey());
			System.out.println("entry's value is : " + entry.getValue());
		}
		
		System.out.println("Bringing key set!");
		System.out.println(freqMap.keySet());
		
		System.out.println("Iterating over keySet!");
		
		for(var key : freqMap.keySet()) {
			System.out.println(key + " " + freqMap.get(key));
		}
		
		System.out.println(freqMap.values());
		
		for(var value : freqMap.values()) {
			System.out.println(value);
		}
		
		freqMap.remove("USA");
		System.out.println(freqMap);
		
	}

}
