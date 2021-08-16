package class31;

import java.util.Arrays;

public class DjikstraAlgorithm {

	static class Graph {

		int numV;
		int[][] costMatrix;

		class Edge {
			int u, v;
			public Edge(int u, int v) {
				this.u = u;
				this.v = v;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + u + ", " + v + "}";
			}
		}
		public Graph(int[][] conn) {
			// TODO Auto-generated constructor stub
			this.numV = conn.length;

			this.costMatrix = new int[numV][numV];

			for (int i = 0; i < this.numV; i++) {
				for (int j = 0; j < this.numV; j++) {
					if (conn[i][j] == 0) {
						costMatrix[i][j] = 999999;
					} else {
						costMatrix[i][j] = conn[i][j];
					}
				}
			}

			for (int i = 0; i < this.numV; i++) {
				for (int j = 0; j < this.numV; j++) {
					if (costMatrix[i][j] == 999999)
						System.out.print("X ");
					else
						System.out.print(costMatrix[i][j] + " ");
				}

				System.out.println();
			}
		}
		
		private void djikstr(int src) {
			// TODO Auto-generated method stub

			boolean[] vis = new boolean[this.numV];
			vis[src] = true;
			System.out.println("Node chosen is : " + src);
			
			int[] dis = new int[this.numV];
			
			for(int i = 0; i < this.numV; i++) {
				dis[i] = this.costMatrix[src][i];
			}
		
			System.out.println(Arrays.toString(dis));
			
			int m;//unvisited shortest distance node
			for(int count = 1; count < this.numV; count++) {
				
				for(m = 0; m < this.numV; m++) {
					if(!vis[m]) {
						break;
					}
				}
				
				
				
				//compare m with other nodes to fetch the shortest distance unvis node
				
				for(int k = m + 1; k < this.numV; k++) {
					if(!vis[k] && dis[k] < dis[m]) {
						m = k;
					}
				}
				//System.out.println(m);
				vis[m] = true;
				
				System.out.println("Node chosen is : " + m);
				for(int n = 0; n < this.numV; n++) {//n = neighbour
					
					if(!vis[n] && dis[m] + this.costMatrix[m][n] < dis[n]) {
						dis[n] = dis[m] + this.costMatrix[m][n];
					}
				}
 			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
				
		Graph g = new Graph(graph);
		g.djikstr(0);
	}

}
