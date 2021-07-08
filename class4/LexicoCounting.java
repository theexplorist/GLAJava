package class4;

public class LexicoCounting {

	
	public static void lexico(int initial, int end) {
		if(initial > end) {
			return;
		}
		
		System.out.println(initial);
		
		int callNumber = 0;
		
		if(initial == 0) {
			callNumber = 1;
		}
		
		while(callNumber <= 9) {
			lexico(initial * 10 + callNumber, end);
			callNumber++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lexico(0, 1000);
	}

}
