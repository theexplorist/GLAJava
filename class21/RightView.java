package class21;

import java.util.ArrayList;
import java.util.List;

import class21.BalancedBinaryTree.TreeNode;

public class RightView {

	 static int maxLvl;

		public List<Integer> rightSideView(TreeNode root) {

			maxLvl = 0;
			List<Integer> ans = new ArrayList<>();
			rightSideView(root, 1, ans);
			return ans;
		}

		public void rightSideView(TreeNode root, int lvl, List<Integer> ans) {
			if (root == null) {
				return;
			}

			if (maxLvl < lvl) {
				ans.add(root.val);
				System.out.println(root.val);
				maxLvl = lvl;
			}

			rightSideView(root.right, lvl + 1, ans);
			rightSideView(root.left, lvl + 1, ans);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
