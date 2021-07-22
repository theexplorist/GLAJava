package class13;
import java.util.Stack;

public class FormMinNumber {

	//Friends And Games
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inp = "IDIIIIDD";
		int n = inp.length();
		
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i <= n; i++) {
			st.push(i + 1);
			
			if(i == n || inp.charAt(i) == 'I') {
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
	}

}
