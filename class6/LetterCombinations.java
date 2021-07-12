package class6;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	static String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {

		if (digits.length() == 0) {
			return new ArrayList<>();
		}
		
		List<String> res = new ArrayList<>();
		helper(digits, "", res);
		return res;
	}

	public static void helper(String digits, String comb, List<String> res) {

		if (digits.length() == 0) {
			res.add(comb);
			System.out.println(comb);
			return;
		}
		char digitPressed = digits.charAt(0); // '2' char
		int index = digitPressed - '0'; // int 2

		String mappedString = mapping[index];
		// System.out.println(mappedString);

		for (int i = 0; i < mappedString.length(); i++) {

			String bachiKuchiString = digits.substring(1);
			char choice = mappedString.charAt(i);
			helper(bachiKuchiString, comb + choice, res);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//helper("27", "");
	}

}
