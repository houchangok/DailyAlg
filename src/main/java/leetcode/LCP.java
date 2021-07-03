package leetcode;

public class LCP {

    public static void main(String[] args) {
        String[] strings = {"sx", "Wsxt", "seo"};
        System.out.println(lpc(strings));
    }

    public static String lpc(String[] strings) {
        if (strings == null || strings.length < 1) {
            return "";
        }
        if (strings.length == 1) {
            return strings[0];
        }
        int lengthOfCommonPrefix = 0;

        while (true) {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i] == null) {
                    return "";
                }
                if (lengthOfCommonPrefix >= strings[i].length()) {
                    return strings[i];
                }
                if (i > 0 && strings[i].charAt(lengthOfCommonPrefix) !=
                        strings[i - 1].charAt(lengthOfCommonPrefix)) {
                    return strings[i].substring(0, lengthOfCommonPrefix);
                }
            }
            lengthOfCommonPrefix++;
        }

    }
}
