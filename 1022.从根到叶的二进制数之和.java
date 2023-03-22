/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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
    public int sumRootToLeaf(TreeNode root) {
      return dfs(0,root);
    }

    public int dfs(int res,TreeNode root) {
      if(root==null){
        return 0;
      }
      res = res *2 +root.val;
      if(root.left==null&&root.right==null){
        return res;
      }
      return dfs(res,root.left)+dfs(res,root.right);
    }
}
// @lc code=end

