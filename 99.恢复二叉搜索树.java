/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode max=null;
    TreeNode min=null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
      dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        if(max!=null&&min!=null){
            TreeNode temp = new TreeNode(0);
            temp.val = max.val;
            max.val = min.val;
            min.val = temp.val;
        }
    }

    public void dfs(TreeNode node,int lower,int upper){
      if(node==null){
            return;
        }

        dfs(node.left,lower,node.val);
        if(prev.val>node.val){
            min = node;
            if(max==null){
                max=prev;
            }
        }
        prev = node;
        dfs(node.right,node.val,upper);

    }
}
// @lc code=end

