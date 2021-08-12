package class30;

import java.util.ArrayList;
import java.util.List;

public class PrimsAlgorithm {

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
						costMatrix[i][j] = Integer.MAX_VALUE;
					} else {
						costMatrix[i][j] = conn[i][j];
					}
				}
			}

			for (int i = 0; i < this.numV; i++) {
				for (int j = 0; j < this.numV; j++) {
					if (costMatrix[i][j] == Integer.MAX_VALUE)
						System.out.print("X ");
					else
						System.out.print(costMatrix[i][j] + " ");
				}

				System.out.println();
			}
		}
		
		private List<Edge> primsAlgorithm() {
			// TODO Auto-generated method stub
			
			//unvisited = {1, 2, 3, 4, 5, 6, 7, 8}
			//Mst = {0}
			boolean[] vis = new boolean[this.numV];
			
			vis[0] = true;
			
			List<Edge> mstEdge = new ArrayList<>();
			int cost = 0;
			for(int ct = 1; ct < this.numV; ct++) {
				int u = 0, v = 0;//chosen edge
				
				for(int i = 0; i < this.numV; i++) {
					for(int j = 0; j < this.numV; j++) {
						if(vis[i] && !vis[j] && costMatrix[i][j] < costMatrix[u][v]) {
							u = i;
							v = j;
						}
					}
				}
				
				//(u, v) -> where u is in mst/vis and v is not visited, cost minimum
				System.out.println("Chosen edge is " + u + "->" + v + " with weight " + costMatrix[u][v]);	
				cost += costMatrix[u][v];
				mstEdge.add(new Edge(u, v));
				//v ko mst mein include
				vis[v] = true;
			}
			
			System.out.println(cost);
			return mstEdge;
		}
	}

	public static void main(String[] args) {
		int[][] conn = { { 0, 3, 0, 2, 0, 0, 0, 0, 4 }, // 0 //9*9
				{ 3, 0, 0, 0, 0, 0, 0, 4, 0 }, // 1
				{ 0, 0, 0, 6, 0, 1, 0, 2, 0 }, // 2
				{ 2, 0, 6, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 8 }, // 4
				{ 0, 0, 1, 0, 0, 0, 8, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 8, 0, 0, 0 }, // 6
				{ 0, 4, 2, 0, 0, 0, 0, 0, 0 }, // 7
				{ 4, 0, 0, 0, 8, 0, 0, 0, 0 } // 8
		};

		Graph g = new Graph(conn);
		System.out.println(g.primsAlgorithm());
	}
}
