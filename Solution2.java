import java.util.List;
import java.util.ArrayList;

import type.TreeNode;

class Solution2 {
    public List<TreeNode> generateTrees(int n) {
        @SuppressWarnings("unchecked")
        List<TreeNode>[] dp = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();
        }
        dp[0].add(null);
        for (int curn = 1; curn <= n; curn++) {
            for (int i = 1; i <= curn; i++) {
                int j = curn - i;
                for (TreeNode left : dp[i - 1]) {
                    for (TreeNode right : dp[j]) {
                        TreeNode root = new TreeNode(i, copyOffset(left, 0), copyOffset(right, i));
                        dp[curn].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    private TreeNode copyOffset(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }
        TreeNode newnode = new TreeNode(node.val + offset);
        newnode.left = copyOffset(node.left, offset);
        newnode.right = copyOffset(node.right, offset);
        return newnode;
    }
}