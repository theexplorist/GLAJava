package class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//adjacency list implementation
public class Graph {

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

	private void bFS(int src) {
		// TODO Auto-generated method stub

		Queue<Integer> bfs = new LinkedList<>();

		bfs.add(src);
		Set<Integer> vis = new HashSet<>();
		vis.add(src);

		while (!bfs.isEmpty()) {
			int front = bfs.poll(); // vertex - 1
			System.out.print(front + " ");

			List<Integer> neighbourList = this.adjList.get(front); // [2, 4]

			for (int neighbour : neighbourList) {
				if (!vis.contains(neighbour)) {
					bfs.add(neighbour);
					vis.add(neighbour);
				}
			}
		}
	}

	private void sSSP(int src) {
		// TODO Auto-generated method stub

		Queue<Integer> bfs = new LinkedList<>();

		bfs.add(src);
		Map<Integer, Integer> dis = new HashMap<>(); // vertex - distance from source
		for (int vertex : adjList.keySet()) {
			dis.put(vertex, Integer.MAX_VALUE);
		}
		dis.put(src, 0);

		while (!bfs.isEmpty()) {
			int front = bfs.poll(); // vertex - 4
			// System.out.print(front + " ");

			List<Integer> neighbourList = this.adjList.get(front); // [1, 3]

			for (int neighbour : neighbourList) {
				if (dis.get(neighbour) == Integer.MAX_VALUE) { // agar neigbhour infinite distance pr hai source se, so
																// it is unvisited
					bfs.add(neighbour);
					int distance = dis.get(front) + 1; // 4 ka distance + 1 = 0 + 1 = 1;
					dis.put(neighbour, distance);
					System.out.println("distance of " + neighbour + " from source " + src + " is " + distance);
				}
			}
		}
	}

	private void dfsHelper(int src, Set<Integer> vis) {
		// TODO Auto-generated method stub
		System.out.print(src + " ");
		vis.add(src);
		
		List<Integer> neighbourList = this.adjList.get(src);
		
		for(int neighbour : neighbourList) {
			if(!vis.contains(neighbour)) {
				dfsHelper(neighbour, vis);
			}
		}
	}

	private void dfs(int src) {
		// TODO Auto-generated method stub

		Set<Integer> vis = new HashSet<>();
		dfsHelper(src, vis);
	}

	private void connectedComponents() {
		// TODO Auto-generated method stub
		Set<Integer> vis = new HashSet<>();
		
		int count = 1;
		for(int vertex : this.adjList.keySet()) {
			if(!vis.contains(vertex)) {
				System.out.print("connected component " + count + " -> ");
				dfsHelper(vertex, vis);
				System.out.println();
				count++;
			}
			
		}
		
	}
	
	private int[] indegree() {
		// TODO Auto-generated method stub

		int[] indegree = new int[numV];
		
		for(List<Integer> neighbourList : this.adjList.values()) {
			
			for(int neighbour : neighbourList) {
				indegree[neighbour]++;
			}
		}
		
		System.out.println(Arrays.toString(indegree));
		return indegree;
	}
	
	private void topologicalSorting() {
		// TODO Auto-generated method stub
		Queue<Integer> bfs = new LinkedList<>();
		int[] indegree = indegree();
		
		for(int vertex = 0; vertex < numV; vertex++) {
			if(indegree[vertex] == 0) {
				bfs.add(vertex);
			}
		}
		
		while(!bfs.isEmpty()) {
			int frontV = bfs.poll();
			
			System.out.print(frontV + " ");
	
			List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());
			
			for(int neighbour : neighbourList) {
				indegree[neighbour]--;
				
				if(indegree[neighbour] == 0) {
					bfs.add(neighbour);
				}
			}
		}
		
		//System.out.println(bfs);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(4);

//		g.addEdge(1, 2, true);
//		g.addEdge(1, 4, true);
//		g.addEdge(2, 3, true);
//		g.addEdge(3, 4, true);
//		g.addEdge(3, 5, true);
//		g.addEdge(5, 6, true);
//		g.addEdge(7, 8, true);
//		g.addEdge(9, 9, false);
		
		//g.dfs(1);
		//g.connectedComponents();
//		g.addEdge(0, 1, false);
//		g.addEdge(0, 2, false);
//		g.addEdge(2, 3, false);
//		g.addEdge(2, 4, false);
//		g.addEdge(3, 1, false);
//		g.addEdge(4, 6, false);
//		g.addEdge(5, 3, false);
//		g.addEdge(5, 6, false);
//		g.display();
//		g.indegree();
//		g.topologicalSorting();

	}

}
