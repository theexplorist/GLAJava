package class5;

public class MazePathFour {

	public static void printPath(int cr, int cc, int er, int ec, String path, boolean[][] vis) {
		if(cr > er || cc > ec || cr < 0 || cc < 0 || vis[cr][cc] == true) {
			return;
		}
		
		if(cr == er && cc == ec) {
			System.out.println(path);
			return;
		}
		
		vis[cr][cc] = true; //topi pehnai
		printPath(cr - 1, cc, er, ec, path + 'U', vis);
		printPath(cr + 1, cc, er, ec, path + 'D', vis);
		printPath(cr, cc - 1, er, ec, path + 'L', vis);
		printPath(cr, cc + 1, er, ec, path + 'R', vis);
		vis[cr][cc] = false; //topi utarna //backtracking
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int m = 3;
		printPath(0, 0, n - 1, m - 1, "", new boolean[n][m]);
	}

}
