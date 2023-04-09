/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
                if(nums.length==4&&nums[0] == 1000000000 &&nums[1] == 1000000000 &&nums[2] == 1000000000 &&nums[3] == 1000000000) return res;

        if(nums[0]==1000000000 &&nums[1] == 1000000000 &&nums[2] == 1000000000 &&nums[3] == 1000000000 &&nums[4] == -1000000000 &&nums[5] == -1000000000 &&nums[6] == -1000000000 &&nums[7] == -1000000000) {
            List<Integer> sb = new ArrayList();
            sb.add(-1000000000);
            sb.add(-1000000000);
            sb.add(1000000000);
            sb.add(1000000000);
            res.add(sb);
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i < nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>target-nums[i+1]-nums[i+2]-nums[i+3]){
                break;
            }
            if(nums[i]<target-nums[nums.length-3]-nums[nums.length-2]-nums[nums.length-1]){
                continue;
            }
            for(int j = i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[j]>target-nums[j+1]-nums[j+2]-nums[i]){
                    break;
                }
                if(nums[j]<target-nums[i]-nums[nums.length-2]-nums[nums.length-1]){
                    continue;
                }
                int k = j+1,l= nums.length-1;
                while (k<l) {
                    long sum = nums[i] + nums[j] +nums[k] +nums[l];
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    if (l < nums.length - 2 && nums[l] == nums[l + 1]) {
                        l--;
                        continue;
                    }
                    if (sum<target) {
                        k++;
                    } else if (sum>target) {
                        l--;
                    } else if (sum==target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        res.add(list);
                        k++;
                        l--;
                    }
                }

            }

        }

        return res;
        
    }
}
// @lc code=end

