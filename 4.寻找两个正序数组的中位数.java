/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m=nums1.length;
    int n=nums2.length;
    int total=m+n;
    int[] res=new int[total];

    if(m==0){
        if(n%2==0){
            return (nums2[n/2-1]+nums2[n/2])/2.0;
        }else{
            return nums2[n/2];
        }
    }

    if(n==0){
        if(m%2==0){
            return (nums1[m/2-1]+nums1[m/2])/2.0;
        }else{
            return nums1[m/2];
        }
    }

    for(int i=0,j=0,k=0;i<total;i++){
        if(j<m&&k<n){
            if(nums1[j]<=nums2[k]){
                res[i]=nums1[j];
                j++;
            }else{
                res[i]=nums2[k];
                k++;
            }            
        }
        else if(j==m){
            res[i]=nums2[k];
            k++;
            if(k==n)break;
        }else{
            res[i]=nums1[j];
            j++;
            if(j==m)break;
        }
    }
    if(total%2==0){
        return (res[total/2-1]+res[total/2])/2.0;
    }else{
        return res[total/2];
    }
}
}
// @lc code=end

