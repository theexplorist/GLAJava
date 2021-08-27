package class37;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	class Node {
		char data;
		Map<Character, Node> children;
		boolean isMarked;
		int freq;

		public Node(char data) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.children = new HashMap<>();
			this.isMarked = false;
			this.freq = 0;
		}
	}

	Node root;

	public Trie() {
		this.root = new Node('*');
	}

	private void insert(String word) {
		// TODO Auto-generated method stub

		Node curr = root;
		for (char c : word.toCharArray()) { //'h', 'a', 'c','k', h a c k e r r a n k
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				Node n = new Node(c);
				curr.children.put(c, n);
				curr = n;
			}
			curr.freq++;
		}

		curr.isMarked = true;
	}

	private boolean search(String word) {
		// TODO Auto-generated method stub

		Node curr = root;
		for (char c : word.toCharArray()) {
			if (curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return false;
			}
		}

		return curr.isMarked;
	}

	public boolean startsWith(String prefix) {
		Node curr = root;
		
		for(char c : prefix.toCharArray()) {
			if(curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	private int countPrefix(String prefix) {
		// TODO Auto-generated method stub
		Node curr = root;
		for(char c : prefix.toCharArray()) {
			if(curr.children.containsKey(c)) {
				curr = curr.children.get(c);
			} else {
				return 0;
			}
		}
		
		return curr.freq;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie trie = new Trie();
//		trie.insert("RAJ");
//		trie.insert("RAM");
//		
//		System.out.println(trie.search("Fa"));
//		trie.insert("apple");
//		System.out.println(trie.search("apple"));
//		System.out.println(trie.search("app"));
//		System.out.println(trie.startsWith("ape"));
		trie.insert("hack");
		trie.insert("hackerrank");
		trie.insert("hackerearth");
		System.out.println(trie.countPrefix("hacker"));
	}

}
