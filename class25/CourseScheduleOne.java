package class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleOne {

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

		private int[] indegree() {
			// TODO Auto-generated method stub

			int[] indegree = new int[numV];

			for (List<Integer> neighbourList : this.adjList.values()) {

				for (int neighbour : neighbourList) {
					indegree[neighbour]++;
				}
			}

			System.out.println(Arrays.toString(indegree));
			return indegree;
		}

		private boolean topologicalSorting(int numCourses) {
			// TODO Auto-generated method stub
			Queue<Integer> bfs = new LinkedList<>();
			int[] indegree = indegree();

			int count = 0;
			for (int vertex = 0; vertex < numV; vertex++) {
				if (indegree[vertex] == 0) {
					count++;
					bfs.add(vertex);
				}
			}

			while (!bfs.isEmpty()) {
				int frontV = bfs.poll();

				System.out.print(frontV + " ");

				List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());

				for (int neighbour : neighbourList) {
					indegree[neighbour]--;

					if (indegree[neighbour] == 0) {
						count++;
						bfs.add(neighbour);
					}
				}
			}

			 System.out.println(count);
			 return count == numCourses ? true : false;
		}

	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1, 0}, {2, 1}, {1, 2}};
		int numCourses = 3;
		
		Graph g = new Graph(numCourses);
		for(int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][1];
			int v = prerequisites[i][0];
			
			//u -> v
			g.addEdge(u, v, false);
		}
		
		g.display();
		System.out.println(g.topologicalSorting(numCourses));
	}
}
