package class15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		
		for(String currString : strs) {
			char[] currStringArray = currString.toCharArray();
			Arrays.sort(currStringArray);
			String sortedStringKey = new String(currStringArray);
			System.out.println(currString + "->" + sortedStringKey);
			if(map.containsKey(sortedStringKey)) {
				List<String> anaList = map.get(sortedStringKey);
				anaList.add(currString);
				map.put(sortedStringKey, anaList);
			} else {
				List<String> anaList = new ArrayList<>();
				anaList.add(currString);
				map.put(sortedStringKey, anaList);
			}
		}
		
		System.out.println(map);
		

		List<List<String>> ans = new ArrayList<>();
		ans.addAll(map.values());
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(arr);
	}

}
