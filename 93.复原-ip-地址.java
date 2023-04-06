import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {

    List<String> res = new ArrayList<>();
    int[] net = new int[4];

    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4||s.length()>12){
            return res;
        }
        dfs(s,0,0);
        return res;
    }

    public void dfs(String s,int level,int pos){
        if(level==4){
            if(pos==s.length()){
                StringBuffer ipAddr = new StringBuffer();
                for(int i = 0; i< 4;i++){
                    ipAddr.append(net[i]);
                    if(i!=3){
                        ipAddr.append(".");
                    }
                }
                res.add(ipAddr.toString());
            }
            return;
        }
        if(pos==s.length()){
            return;
        }
        if(s.charAt(pos)=='0'){
            net[level]=0;
            dfs(s, level+1, pos+1);
        }
        int addr=0;

        for(int end = pos;end < s.length();end++){
            addr = addr *10 +(s.charAt(end)-'0');
            if(addr>0&&addr<=255){
                net[level]=addr;
                dfs(s, level+1, pos+1);
            }else{
                break;
            }
        }

        return;
    }
}
// @lc code=end

