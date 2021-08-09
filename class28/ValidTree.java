package class28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ValidTree {

	static class Graph {

		// vertex - list of neighbours to that vertex
		Map<Integer, List<Integer>> adjList;

		int numV;
		public Graph(int numV) {
			adjList = new HashMap<>();
			this.numV = numV;
		}

		// u and v mein add edge
		// isBidir = true -> undirected edge, false -> directed edge
		private void addEdge(int u, int v, boolean isBidir) {
			// TODO Auto-generated method stub

			// u -> v edge 1 -> 2

			// 1 ki neighbour list
			List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
			uNeighbour.add(v);
			this.adjList.put(u, uNeighbour);

			if (isBidir) {
				// v -> u edge 2 -> 1

				// 2 ki neighbour list
				List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());

				// 2 ka neighbour 1
				vNeighbour.add(u);

				this.adjList.put(v, vNeighbour);
			}

		}

		private void display() {
			// TODO Auto-generated method stub

			for (Map.Entry<Integer, List<Integer>> entry : this.adjList.entrySet()) {
				int vertex = entry.getKey();
				List<Integer> neighbourList = entry.getValue();
				System.out.println(vertex + " -> " + neighbourList);
			}
		}
		
		private boolean isValidTree(int n) {
			// TODO Auto-generated method stub

			Set<Integer> vis = new HashSet<>();
			int[] parent = new int[n];
			Queue<Integer> bfs = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				parent[i] = i;
			}
			
			bfs.add(0);
			vis.add(0);
			
			while(!bfs.isEmpty()) {
				int frontV = bfs.poll();
				
				for(int neighbour : this.adjList.getOrDefault(frontV, new ArrayList<>())) {
					if(!vis.contains(neighbour)) {
						bfs.add(neighbour);
						vis.add(neighbour);
						parent[neighbour] = frontV;
					} else if(parent[frontV] != neighbour) {
						return false; // not tree
					}
				}
			}
			
			//no cycle
			System.out.println(vis);
			return vis.size() == n; //false -> graph that is not connected, tree should be connected.
		}
		
		private boolean dFS(int src, Set<Integer> vis, int parent) {
			// TODO Auto-generated method stub

			//System.out.print(src);
			vis.add(src);
			
			boolean hasCycle = false;
			for(int neighbour : this.adjList.getOrDefault(src, new ArrayList<>())) {
				if(!vis.contains(neighbour)) {
					hasCycle = dFS(neighbour, vis, src);
					return hasCycle;
				} else if(parent != neighbour) {
					return true;
				}
			}
			
			return hasCycle;
		}
		
		private void hasCycle() {
			// TODO Auto-generated method stub

			Set<Integer> vis = new HashSet<>();
			
			for(int v = 0; v < this.numV; v++) {
				if(!vis.contains(v)) {
					System.out.println(dFS(v, vis, v));
				}
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[][] edges = {{1, 2}, {2, 3},  {1, 3}};
		int n = 4;
		
//		//1 condn
//		if(edges.length < n - 1) {
//			System.out.println("false");
//			return;
//		}
		
		Graph g = new Graph(n);
		for(int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			
			//u -> v, v -> u
			
			g.addEdge(u, v, true);
		}
		
		g.display();
		g.hasCycle();
		System.out.println(g.isValidTree(n));
	}
}
