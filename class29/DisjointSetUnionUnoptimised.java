package class29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSetUnionUnoptimised {

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

		private void display() {
			// TODO Auto-generated method stub
			System.out.println(this.edgeList);
		}

		private int find(int[] parent, int u) { // find u ka godfather i.e vertex with no parent = -1
			// TODO Auto-generated method stub

			if(parent[u] == -1) { //mil gaya godfather
				return u;
			}
			
			return find(parent, parent[u]);
		}
		
		private void union(int u, int v, int[] parent) {
			// TODO Auto-generated method stub
			int godFatherU = this.find(parent, u);
			int godFatherV = this.find(parent, v);
			
			//godFatherU ko  godFatherV ka child
			
			if(godFatherU != godFatherV) {
				parent[godFatherU] = godFatherV;
			}
		}
		
		private boolean detectCycle(int[] parent) {
			// TODO Auto-generated method stub
			
			for(Edge edge : this.edgeList) {
				int u = edge.u;
				int v = edge.v;
				
				int godFatherU = this.find(parent, u);
				int godFatherV = this.find(parent, v);
				
				//agar equal ni hai
				
				if(godFatherU != godFatherV) {
					this.union(godFatherU, godFatherV, parent);
				} else { //equal bole to cycle
					return  true;
				}
			}
			
			return false;
		}
	}

	public static void main(String[] args) {
		EdgeList g = new EdgeList(5);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);

		g.addEdge(1, 4);
		g.addEdge(4, 2);
		g.display();
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		
		System.out.println(g.detectCycle(parent));
	}
}
