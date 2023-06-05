import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import javafx.scene.Node;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    public void dfs(TreeNode node,int pre){
        pre=pre*10+node.val;
        if(node.left==null&&node.right==null){
            total=total+pre;
        }
        if(node.left!=null){
            dfs(node.left, pre);
        }

        if(node.right!=null){
            dfs(node.right, pre);
        }
        
    }
}
// @lc code=end

