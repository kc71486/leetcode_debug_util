package util;

import java.util.ArrayDeque;
import java.util.Queue;

import type.TreeNode;

public class TreeGenerator {
    public static TreeNode getTree(Integer[] list) {
        TreeNode head = new TreeNode(list[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode holding = head;
        boolean goleft = true;
        for(int i=1; i<list.length; i++) {
            Integer listval = list[i];
            if(holding == null) {
                holding = q.poll();
            }
            if(goleft) {
                if(listval != null) {
                    holding.left = new TreeNode(listval.intValue());
                    q.offer(holding.left);
                }
                goleft = false;
            }
            else {
                if(listval != null) {
                    holding.right = new TreeNode(listval.intValue());
                    q.offer(holding.right);
                }
                goleft = true;
                holding = null;
            }
        }
        return head;
    }
}
