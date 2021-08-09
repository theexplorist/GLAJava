package class28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleInDirectedGraph {

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
		
		//Do not set for backtracking, as set do not preserve order so last element removal is not feasible.
		private boolean dFS(int src, Set<Integer> vis, List<Integer> path) {
			// TODO Auto-generated method stub

			vis.add(src);
			path.add(src);
			//recursion
			boolean hasCycle = false;
			for(int neighbour : this.adjList.getOrDefault(src, new ArrayList<>())) {
				if(!vis.contains(neighbour)) {
					
					hasCycle = dFS(neighbour, vis, path);
					
				} else if(path.contains(neighbour)) {
					return true;
				}
			}
			
			//System.out.println(path);
			path.remove(path.size() - 1);	
			//System.out.println(":" + path);
			return hasCycle;
		}
		private void detectCycle() {
			// TODO Auto-generated method stub

			Set<Integer> vis = new HashSet<>();
			List<Integer> path = new ArrayList<>();
			
			System.out.println(dFS(0, vis, path));	
		}

	}

	public static void main(String[] args) {

		Graph g = new Graph(7);
		
		g.addEdge(0, 1, false);
		g.addEdge(1, 5, false);
		g.addEdge(1, 2, false);
		g.addEdge(5, 6, false);
		g.addEdge(2, 3, false);
		g.addEdge(3, 4, false);
		g.addEdge(4, 5, false);
		g.addEdge(4, 2, false);
		
		g.display();
		
		g.detectCycle();
	}
}
