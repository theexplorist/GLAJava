package class6;

public class NQueen2 {

	static int count;

	private static boolean kyaMainQueenRakhSaktaHun(int[][] board, int cr, int cc, int n) {
		// TODO Auto-generated method stub

		for (int row = 0; row <= cr - 1; row++) {
			if (board[row][cc] == 1) {
				return false;
			}
		}

		int row = cr;
		int col = cc;

		while (row >= 0 && col >= 0) {
			if (board[row][col] == 1) {
				return false;
			}
			row--;
			col--;
		}

		row = cr;
		col = cc;

		while (row >= 0 && col < n) {
			if (board[row][col] == 1) {
				return false;
			}
			row--;
			col++;
		}

		return true;
	}

	private static void queenConf(int[][] board, int cr, int n) {
		// TODO Auto-generated method stub

		if (cr == n) {

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1)
						System.out.print("Q ");
					else
						System.out.print("- ");

				}
				System.out.println();
			}
			System.out.println("----------------");
			count++;
			return;
		}

		for (int cc = 0; cc < n; cc++) {
			if (kyaMainQueenRakhSaktaHun(board, cr, cc, n) == true) {
				board[cr][cc] = 1;
				queenConf(board, cr + 1, n);
				board[cr][cc] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] board = new int[n][n]; // All 0, no queen is placed iniitally

		count = 0;
		queenConf(board, 0, n);
		System.out.println(count);

	}

}
