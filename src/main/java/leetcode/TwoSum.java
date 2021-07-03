package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        TwoSum twoSum = new TwoSum();
//        System.out.println(twoSum.twoSum(nums, target));
        int[] res = twoSum.twoSum(nums, target);
        System.out.println("index are " + res[0] + " and " + res[1]);
    }

    public int[] twoSum(int nums[], int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return res;

    }


}
