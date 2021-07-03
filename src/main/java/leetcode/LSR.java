package leetcode;

import java.util.HashMap;

public class LSR {
    public static void main(String[] args) {
        System.out.println(longestNoRepeatSubString("abcabbb"));
    }

    public static int longestNoRepeatSubString(String s) {
        //参数校验
        if (s == null || s.length() < 1) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int lastDuplicateIndex = -1;
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer index = map.get(chars[i]);
            //存在重复字符的情况
            if (index != null && lastDuplicateIndex < index) {
                lastDuplicateIndex = index;
            }
            maxLen = Math.max(maxLen, i - lastDuplicateIndex);
            map.put(chars[i], i);
        }
        return maxLen;
    }
}
