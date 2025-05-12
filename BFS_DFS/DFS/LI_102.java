// 리트코드 102번
// BFS로 대개 풀지만, dfs 방식대로 독특하게 품

import java.util.ArrayList;
import java.util.List;

public class LI_102 {
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

  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root != null) {
        dfsLevelOrder(root, 0, result);
      }
      return result;
    }

    private void dfsLevelOrder(TreeNode node, int depth, List<List<Integer>> result) {
      if (result.size() == depth) {
        result.add(new ArrayList<>());
      }
      result.get(depth).add(node.val);

      if (node.left != null) {
        dfsLevelOrder(node.left, depth + 1, result);
      }
      if (node.right != null) {
        dfsLevelOrder(node.right, depth + 1, result);
      }
    }
  }
}
