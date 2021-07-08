package class3;

public class SubsequenceGenerate {

	static int count;

	public static int genSubs2(String input, String ans) {

		if (input.length() == 0) {
			
			System.out.println(ans);
			return 1;
		}
		
		int count = 0;
		char cc = input.charAt(0); // a

		count = count + genSubs2(input.substring(1), ans);
		
		count = count + genSubs2(input.substring(1), ans + cc);

		return count;
	}
	public static void genSubs(String input, String ans) {

		if (input.length() == 0) {
			count++;
			System.out.println(ans);
			return;
		}
		char cc = input.charAt(0); // a

		genSubs(input.substring(1), ans);
		genSubs(input.substring(1), ans + cc);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		count = 0;
		int ct = genSubs2("abc", "");
		System.out.println(ct);
	}

}
