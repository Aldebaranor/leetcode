/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(divisor==1) return dividend;
        if(divisor==-1){
            if(dividend>-2147483648) return -dividend;
            return 2147483647;
        }
        long a = dividend;
        long b = divisor;
        boolean tag=true;
        if((a>0&&b<0)||(a<0&&b>0)){
            tag=false;
        }
        a=a>0?a:-a;
        b=b>0?b:-b;
        int res=div(a,b);
        if(tag)return res>2147483647?2147483647:res;
        return -res;
    }
    int div(long a,long b){
        if(a<b) return 0;
        int count = 1;
        long temp=b;
        while((temp + temp)<=a){
            count+=count;
            temp+=temp;
        }
        return count + div(a-temp,b);
    }
}
// @lc code=end

