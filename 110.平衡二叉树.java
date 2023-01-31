/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {

      return balanced(root)!= -1;

    }

    public int balanced(TreeNode node){
      if(node==null){
        return 0;
      }
      int leftHeight,rightHeight;
      if((leftHeight=balanced(node.left))==-1 
      || (rightHeight=balanced(node.right))==-1 
      || Math.abs(leftHeight-rightHeight)>1)
      return -1;
      return Math.max(leftHeight,rightHeight)+1;
    }

}
// @lc code=end

