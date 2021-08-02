package class22;

import java.util.HashMap;
import java.util.Map;

public class PreInBuild {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	int preOrderIter;
    Map<Integer, Integer> inOrdMapping;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preOrderIter = 0;
        inOrdMapping = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            inOrdMapping.put(inorder[i], i); //element - index pair
        }
        
        return buildTree(preorder, 0, preorder.length - 1);
    }
    //left -> 0, right -> preOrder.le - 1
    public TreeNode buildTree(int[] preorder, int left, int right) {
        
    	if(left > right) {
    		return null;
    	}
        int rootVal = preorder[preOrderIter++];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inOrdMapping.get(rootVal);
        
        //left - [0, rootIndex - 1], right - [rootIndex + 1, ]
        
        root.left = buildTree(preorder, left, rootIndex - 1);
        root.right = buildTree(preorder, rootIndex + 1, right);
        
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
