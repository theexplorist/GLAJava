package class5;

public class MazePathTwoDir {

	static int count;
	public static void printPath(int cr, int cc, int er, int ec, String path) {
		if(cr > er || cc > ec) {
			
			return;
		}
		
		if(cr == er && cc == ec) {
			count++;
			System.out.println(path);
			return;
		}
		
		printPath(cr, cc + 1, er, ec, path + 'H');
		printPath(cr + 1, cc, er, ec, path + 'V');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int m = 3;
		count = 0;
		printPath(0, 0, n - 1, m - 1, "");
		System.out.println(count);
	}

}
