package class10;

public class MinPathSum {

	private static int sol(int[][] grid, int cr, int cc, int er, int ec) {
		// TODO Auto-generated method stub

		if(cr > er || cc > ec) {
			return 0;
		}
		
		if(cr == er && cc == ec) {
			return grid[cr][cc];
		}
		int c1 = sol(grid, cr, cc + 1, er, ec); //right
		int c2 = sol(grid, cr + 1, cc, er, ec); //down
		int minAns = Math.min(c1, c2);
		return grid[cr][cc] + minAns;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
