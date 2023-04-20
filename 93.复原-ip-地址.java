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
        List<String> res = new ArrayList<>();
        if (s.length() > 12 || s.length() < 4) {
            return res;
        }
        dfs(res, s, "", 0, 0);
        return res;
    }

    public void dfs(List<String> res, String s, String str, int level, int pos){
        if (level == 4 && pos == s.length()) {
            res.add(str);
            return;
        }
        if ((4 - level) * 3 < s.length() - pos) {
            return;
        }
        int addr = 0;
        for (int i = pos; i < s.length(); i++) {
            if (s.charAt(pos) == '0' && i > pos) {
                break;
            }
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr <= 255 && addr >= 0) {
                dfs(res, s, str+addr+((level==3)?"":"."), level + 1, i + 1);
            } else {
                return;
            }
        }

        return;
    }
}
// @lc code=end

