import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        pre(root, list);
        int size = list.size();
        for(int i=1;i<size;i++){
            TreeNode prev = list.get(i-1),curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void pre(TreeNode node,List<TreeNode> list){
        if(node!=null){
            list.add(node);
            pre(node.left, list);
            pre(node.right, list);
        }
    }
}
// @lc code=end

