package leetcode;

public class MaxWater {
    public static void main(String[] args) {
        int[] height = {2, 4, 2, 6, 4, 2, 10, 8};
        System.out.println(getMaxWater(height));
    }

    public static int getMaxWater(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            //
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
