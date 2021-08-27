package class37;

public class FormBiggestNumber {

	private static int compare(int x, int y) { //x -> curr, y = curr + 1
		// TODO Auto-generated method stub

		String xy = x + "" + y;
		String yx = y + "" + x;
		
		int valxy = Integer.valueOf(xy);
		int valyx = Integer.valueOf(yx);
		
		if(valxy > valyx) {
			return -1; //no swapping requireed
		} else {
			return 1; //swapping required
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {54, 546, 548, 60};
		int n = arr.length;
		
		for(int cp = 1; cp <= n - 1; cp++) { //1, 2, 3
			
			for(int curr = 0; curr <= n - cp - 1; curr++) {
				if(compare(arr[curr], arr[curr + 1]) > 0) {
					int temp = arr[curr];
					arr[curr] = arr[curr + 1];
					arr[curr + 1] = temp;
				}
			}
		}
	}

}
