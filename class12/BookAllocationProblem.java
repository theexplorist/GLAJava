package class12;

public class BookAllocationProblem {

	private static boolean canReadForCapacity(int[] pages, int numSt, int maxCap) {
		// TODO Auto-generated method stub

		int stNum = 1;
		int pagesRead = 0;
		
		int bookNum = 0;
		
		while(bookNum < pages.length) {
			
			if(pages[bookNum] + pagesRead <= maxCap) {
				pagesRead += pages[bookNum];
				bookNum++;
			} else {
				stNum++;
				pagesRead = 0;
			}
			
			if(stNum > numSt) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pages = {10, 20, 30, 40};
		int n = 4;
		int numSt = 2;
		int sum = 10 + 20 + 30 + 40 ;
		
		int l = 0, r = sum;
		
		while(r > l + 1) {
			int mid = (l + r) / 2; //maxCapacity
			
			if(canReadForCapacity(pages, numSt, mid)) {
				r = mid;
			} else {
				l = mid;
			}
		}
		
		System.out.println(r);
	}

}
