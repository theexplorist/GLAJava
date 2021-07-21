package class12;

import java.util.Stack;

public class StackClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> st = new Stack<>();
		System.out.println(st.isEmpty());
		st.push(1);
		st.push(3);
		st.push(5);
		
		
		System.out.println(st.peek());
		System.out.println(st.pop());
		
		System.out.println(st.peek());
		
		System.out.println(st.isEmpty());
	}

}
