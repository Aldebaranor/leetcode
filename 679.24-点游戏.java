/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24 点游戏
 */

// @lc code=start
class Solution {
    public boolean judgePoint24(int[] cards) {

        List<Double> list = new ArrayList<Double>();
        for(int num:cards){
            list.add((double) num);
        }

        return solve(list);
    }

    public boolean solve(List<Double> list){

        int n = list.size();
        if(n==0){
            return false;
        }
        if(n==1){
            if(Math.abs(list.get(0)-24)<1e-6){
                return true;
            }else return false;
        }

        for(int k = 0;k < n;k++){
            for(int j = 0;j < n;j++) {
                if (j != k) {
                    List<Double> list1 = new ArrayList<Double>();

                    for (int i = 0; i < n; i++) {
                        if (i != k && i != j) {
                            list1.add(list.get(i));
                        }
                    }
                    for (int l = 0; l < 4; l++) {
                        if(l<2&&k>j){
                            continue;
                        }
                        if (l == 0) {
                            list1.add(list.get(k) + list.get(j));
                        } else if (l == 1) {
                            list1.add(list.get(k) * list.get(j));
                        } else if (l == 2) {
                            list1.add(list.get(k) - list.get(j));
                        } else if (l == 3) {
                            if (list.get(j) == 0) {
                                continue;
                            } else {
                                list1.add(list.get(k) / list.get(j));
                            }
                        }
                        if (solve(list1)) {
                            return true;
                        }
                        list1.remove(list1.size() - 1);
                    }
                }
            }
        }

        return false;
    }
}
// @lc code=end

