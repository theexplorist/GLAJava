package class25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {

	
	static class Graph {
		Map<Character, List<Character>> adjL;
		int numV;
		public Graph(int numV) {
			this.adjL = new HashMap<>();
			this.numV = numV;
		}
		
		private void addEdge(String[] str, int n) {
			// TODO Auto-generated method stub
			
			for(int i = 0; i < n - 1; i++) {
				String s1 = str[i];
				String s2 = str[i + 1];
				
				for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
					if(s1.charAt(j) != s2.charAt(j)) {
						//s1.charAt(j) -> s2.charAt(j)
						
						List<Character> neighbourL = this.adjL.getOrDefault(s1.charAt(j), new ArrayList<>());
						neighbourL.add(s2.charAt(j));
						adjL.put(s1.charAt(j), neighbourL);
						break;
					}
				}
			}
		}
		
		private void display() {
			// TODO Auto-generated method stub
			
			for(var entry : this.adjL.entrySet()) {
				char vertex = entry.getKey();
				List<Character> neighbourL = entry.getValue();
				
				System.out.println(vertex + " -> " + neighbourL);
			}
		}
		
		private Map<Character, Integer> indegree() {
			// TODO Auto-generated method stub

			Map<Character, Integer> indegree = new HashMap<>();
			
			for(List<Character> neighbourL : this.adjL.values()) {
				
				for(char cc : neighbourL) {
					int value = indegree.getOrDefault(cc, 0);
					indegree.put(cc, value + 1);
				}
			}
			
			for(char key : this.adjL.keySet()) {
				if(!indegree.containsKey(key)) {
					indegree.put(key, 0);
				}
			}
			System.out.println(indegree);
			
			return indegree;
		}
		
		private void topologicalSorting() {
			// TODO Auto-generated method stub

			Map<Character, Integer> indegree = this.indegree();
			
			Queue<Character> bfs = new LinkedList<>();
			
			for(char vertex : indegree.keySet()) {
				int indV = indegree.get(vertex);
				if(indV == 0) {
					bfs.add(vertex);
				}
			}
				
			
			
			while(!bfs.isEmpty()) {
				char front = bfs.poll();
				
				System.out.print(front);
				
				for(char neighbourChar : this.adjL.getOrDefault(front, new ArrayList<>())) {
					//indegree[neighbourChar - 'a']--;
					int indN = indegree.get(neighbourChar);
					indN--;
					indegree.put(neighbourChar, indN);
					
					if(indN == 0) {
						bfs.add(neighbourChar);
					}
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] str = {"wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"};
		int n = 5;
		int k = 4; //a , b , c, d vertices
		
		Graph g = new Graph(k);
		
		g.addEdge(str, n);
		g.display();
		g.indegree();
		g.topologicalSorting();
	}

}
