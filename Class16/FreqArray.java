package Class16;

public class FreqArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] freq = new int[26];
		String str = "eat";
		for(int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i); //e
			int index = cc - 'a';//'e' - 'a' -> index = 4
			freq[index]++;
		}
		
		for(int e : freq) {
			System.out.print(e + " ");
		}
	}

}
