package leetcode;

import java.util.Arrays;

public class ClosetSum {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1 - 4};
        int target = 1;
        System.out.println(closetThreeSum(nums, target));
    }

    public static int closetThreeSum(int[] nums, int target) {
        int minDist = Integer.MIN_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    if (sum - target < minDist) {
                        minDist = sum - target;
                        res = sum;
                    }
                    r--;
                } else {
                    if (target - sum < minDist) {
                        minDist = target - sum;
                        res = sum;
                    }
                    l++;
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;

    }

}
