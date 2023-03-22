/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> res1 = new ArrayList<Integer>();
      if(root1!=null){
      dfs(root1,res1);
      }

      List<Integer> res2 = new ArrayList<Integer>();
      if(root2!=null){
      dfs(root2,res2);
      }

      return res1.equals(res2);
    }

    public void dfs(TreeNode node,List<Integer> res){
      if(node.left==null&&node.right==null){
        res.add(node.val);
        return;
      }
      if(node.left!=null){
        dfs(node.left,res);
      }
      if(node.right!=null){
        dfs(node.right,res);
      }
    }
}
// @lc code=end

