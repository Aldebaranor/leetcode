/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] arr,int target){
        int left = 0,right = arr.length-1;
        while(left<=right){
            int mid = (right-left) / 2 + left;
            int num = arr[mid];
            if(num == target){
                return mid;
            }else if (num > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

