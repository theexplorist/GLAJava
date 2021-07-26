package Class16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		
		for(String currString : strs) {
			int[] freq = new int[26];
		
			for(int i = 0; i < currString.length(); i++) {
				char cc = currString.charAt(i); //e
				int index = cc - 'a';//'e' - 'a' -> index = 4
				freq[index]++;
			}
			
			
			//System.out.print(currString + "->");
			StringBuilder sb = new StringBuilder();
			for(int e : freq) {
				sb.append(e);
				sb.append('|');
			}
			
			String key = sb.toString();
			

			//System.out.println();
			/*
			if(map.containsKey(sortedStringKey)) {
				List<String> anaList = map.get(sortedStringKey);
				anaList.add(currString);
				map.put(sortedStringKey, anaList);
			} else {
				List<String> anaList = new ArrayList<>();
				anaList.add(currString);
				map.put(sortedStringKey, anaList);
			}
			
		*/
			
			List<String> anaList = map.getOrDefault(key, new ArrayList<>());
			anaList.add(currString);
			map.put(key, anaList);
			
			
		}
		
		System.out.println(map);
		

		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = {"aaaaaaaaaab", "acccccccccc"};
		groupAnagrams(arr);
	}

}
