import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {

        String ans = "";
        int len = s.length();
        int t = 2*numRows-2;
        String temp ="";

        List<String> list[] = new ArrayList[numRows];
        for(int i = 0;i<numRows;i++){
            list[i] = new ArrayList<String>();
        }

        if(len<=numRows||numRows==1){
            return s;
        }
        for(int i = 0;i < len;i++){
            int key=i%t;
            if(key<numRows){
                temp = String.valueOf(s.charAt(i));
                list[key].add(temp);
            } else{
                temp = String.valueOf(s.charAt(i));
                list[t-key].add(temp);
            }
        }
        for(int i = 0;i<numRows;i++){
            for(String item:list[i]) {
                ans = ans.concat(item);
            }
        }
        return ans;
    }
}
// @lc code=end

