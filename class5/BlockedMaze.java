package class5;

public class BlockedMaze {

	
	static boolean hasPath;
	public static void printPath(int[][] maze, int cr, int cc, int er, int ec, String path, boolean[][] vis) {
		if (cr > er || cc > ec || cr < 0 || cc < 0 || vis[cr][cc] == true || maze[cr][cc] == 1) {
			return;
		}

		if (cr == er && cc == ec) {
			hasPath = true;
			System.out.println(path);
			return;
		}

		vis[cr][cc] = true; // topi pehnai
		printPath(maze, cr - 1, cc, er, ec, path + 'U', vis);
		printPath(maze, cr + 1, cc, er, ec, path + 'D', vis);
		printPath(maze, cr, cc - 1, er, ec, path + 'L', vis);
		printPath(maze, cr, cc + 1, er, ec, path + 'R', vis);
		vis[cr][cc] = false; // topi utarna //backtracking
	}

	public static void main(String[] args) {

		int[][] maze = { {0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 1, 0 } };

		hasPath = false;
		printPath(maze, 0, 0, 3, 3, "", new boolean[4][4]);
		System.out.println(hasPath);
	}
}
