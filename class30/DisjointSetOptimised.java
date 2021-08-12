package class30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSetOptimised {

	static class EdgeList {

		class Edge {
			int u;
			int v;

			public Edge(int u, int v) {
				this.u = u;
				this.v = v;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + this.u + ", " + this.v + "}";
			}
		}

		int numV;
		List<Edge> edgeList;

		public EdgeList(int numV) {
			// TODO Auto-generated constructor stub
			this.numV = numV;
			this.edgeList = new ArrayList<>();
		}

		private void addEdge(int u, int v) {
			// TODO Auto-generated method stub

			Edge edge = new Edge(u, v);
			this.edgeList.add(edge);
		}
		
		//u ka godfather dhundo, aisa vertex jiks parent -1
		private int find(int[]parent, int u) {
			// TODO Auto-generated method stub

			if(parent[u] == -1) {//godfather, leader, parent of itself
				return u;
			}
			
			return parent[u] = find(parent, parent[u]);
		}
		
		private void union(int[] parent, int[] rank, int u, int v) {
			// TODO Auto-generated method stub

			//find godfather of u and v both
			
			int godFatherU = this.find(parent, u);
			int godFatherV = this.find(parent, v);
			
			if(godFatherU != godFatherV) {
				int godFatherURank = rank[godFatherU];
				int godFatherVRank = rank[godFatherV];
				
				if(godFatherURank < godFatherVRank) {
					// u banega v ka bacha
					parent[godFatherU] = godFatherV;
					rank[godFatherV] += rank[godFatherU];
				} else {
					//v banega u ka bacha
					parent[godFatherV] = godFatherU;
					rank[godFatherU] += rank[godFatherV];
				}			
			}
		}
		
		private boolean detectCycle(int[] parent, int[] rank) {
			// TODO Auto-generated method stub
			
			for(Edge edge : this.edgeList) {
				int u = edge.u;
				int v = edge.v;
				
				int godFatherU = this.find(parent, u);
				int godFatherV = this.find(parent, v);
				
				//agar equal ni hai
				
				if(godFatherU != godFatherV) {
					this.union(parent,rank, godFatherU, godFatherV);
				} else { //equal bole to cycle
					return  true;
				}
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		
		int[] rank = new int[n];
		Arrays.fill(rank, 1);
		
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		
		EdgeList g = new EdgeList(n);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		//g.addEdge(0, 2);
		//g.union(parent, rank, n, n);
		System.out.println(g.detectCycle(parent, rank));
	}
}
