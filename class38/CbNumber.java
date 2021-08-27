package class38;

public class CbNumber {

	private static boolean isVis(boolean[] vis, int si, int ei) { //si -> inc, ei -> exc
		// TODO Auto-generated method stub

		for(int i = si; i < ei; i++) {
			if(vis[i] == true) {
				return true;
			}
		}
		
		return false;
	}
	private static boolean isCbNum(String subStr) {
		// TODO Auto-generated method stub

		long subStrVal = Long.valueOf(subStr);
		if(subStrVal == 0 || subStrVal == 1) {
			return false;
		}
		
		long[] l = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
		
		for(long e : l) {
			if(e == subStrVal) {
				return true;
			}
		}
		
		for(long e : l) {
			if(subStrVal % e== 0) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "4992";
		int ct = 0;
		boolean[] vis = new boolean[str.length()];
		for(int l = 1; l <= str.length(); l++) {
			for(int si = 0; si <= str.length() - l; si++) {
				int ei = si + l;
				
				String subStr = str.substring(si,ei);
				
				if(isCbNum(subStr) == true && isVis(vis, si, ei) == false) {
					ct++;
					for(int i = si; i < ei; i++) {
						vis[i] = true;
					}
				}
			}
		}
		
		System.out.println(ct);
	}

}
