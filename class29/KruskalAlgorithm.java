package class29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgorithm {

	static class EdgeList {

		class Edge {
			int u;
			int v;
			int wt;
			public Edge(int u, int v, int wt) {
				this.u = u;
				this.v = v;
				this.wt = wt;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + this.u + ", " + this.v +  ", " + this.wt + "}";
			}
		}

		int numV;
		List<Edge> edgeList;

		public EdgeList(int numV) {
			// TODO Auto-generated constructor stub
			this.numV = numV;
			this.edgeList = new ArrayList<>();
		}

		private void addEdge(int u, int v, int wt) {
			// TODO Auto-generated method stub

			Edge edge = new Edge(u, v, wt);
			this.edgeList.add(edge);
		}

		private void display() {
			// TODO Auto-generated method stub
			System.out.println(this.edgeList);
		}

		private int find(int[] parent, int u) { // find u ka godfather i.e vertex with no parent = -1
			// TODO Auto-generated method stub

			if (parent[u] == -1) { // mil gaya godfather
				return u;
			}

			return find(parent, parent[u]);
		}

		private void union(int u, int v, int[] parent) {
			// TODO Auto-generated method stub
			int godFatherU = this.find(parent, u);
			int godFatherV = this.find(parent, v);

			// godFatherU ko godFatherV ka child

			if (godFatherU != godFatherV) {
				parent[godFatherU] = godFatherV;
			}
		}

		private boolean detectCycle(int[] parent) {
			// TODO Auto-generated method stub

			for (Edge edge : this.edgeList) {
				int u = edge.u;
				int v = edge.v;

				int godFatherU = this.find(parent, u);
				int godFatherV = this.find(parent, v);

				// agar equal ni hai

				if (godFatherU != godFatherV) {
					this.union(godFatherU, godFatherV, parent);
				} else { // equal bole to cycle
					return true;
				}
			}

			return false;
		}

		private int kruskalAlgorithm(int[] parent) {
			// TODO Auto-generated method stub
			//step 1 -> sort edge in inc order of wt
			
			Collections.sort(this.edgeList, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) { //o1 -> curr, o2 -> curr + 1
					// TODO Auto-generated method stub
					return o1.wt - o2.wt;
				}
			});
			
			System.out.println(this.edgeList);
			
			int minCost = 0;
			
			for(Edge edge : this.edgeList) {
				int u = edge.u;
				int v = edge.v;
				int wt = edge.wt;
				//step 2 - find godfather
				int godFatherU = this.find(parent, u);
				int godFatherV = this.find(parent, v);
				
				//step3 - can we do a union without forming cycle
				
				if (godFatherU != godFatherV) {
					this.union(godFatherU, godFatherV, parent);
					minCost += wt;
				}
			}
			
			return minCost;
		}
	}
	
	public static void main(String[] args) {
		EdgeList g = new EdgeList(4);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 2);
		g.addEdge(1, 4, 2);
		g.addEdge(2, 4, 3);
		g.addEdge(2, 3, 2);
		g.addEdge(3, 4, 3);
		
		g.display();
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		System.out.println(g.kruskalAlgorithm(parent));
	}
}
