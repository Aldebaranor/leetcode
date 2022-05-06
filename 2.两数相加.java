/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int flag = 0;
        int l1num=0,l2num=0;
        ListNode start = new ListNode();
        ListNode ans = start;

        while(l1!=null||l2!=null) {
            if(l1==null){
                l1num=0;
            }else {
                l1num=l1.val;
            }
            if(l2==null){
                l2num=0;
            }else {
                l2num=l2.val;
            }
            ans.val = l1num + l2num + flag;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }

            flag = (ans.val >= 10) ? 1 : 0;
            if(flag==1){
                ans.val=ans.val%10;
                ans.next=new ListNode(1);
            }else if(l1!=null||l2!=null){
                ans.next=new ListNode(0);
            }
            ans = ans.next;
        }
        return start;

    }
}
// @lc code=end

