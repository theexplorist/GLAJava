package class3;

public class SubstringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String str = "kartik";
		
		//artik
		System.out.println(str.substring(1)); //1 -> end
		
		//rtik
		System.out.println(str.substring(2)); //2 -> end
		
		System.out.println(str.substring(0, 3)); //3 exc
		System.out.println(str.substring(1, 4)); //4 exc
		*/
		String n = "coding";
		int ci = 3;
		String s = n.substring(0, ci) + n.substring(ci + 1);
		System.out.println(s);
	}

}
