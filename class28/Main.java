package class28;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		System.out.println(s);
		s.remove(s.size() - 1);
		System.out.println(s);
		
	}

}
