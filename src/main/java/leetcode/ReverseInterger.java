package leetcode;

public class ReverseInterger {

    public static void main(String[] args) {
        System.out.println(reverse(-133312));
    }

    public static int reverse(Integer x) {
        boolean sign = x > 0;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            //溢出了返回0，这个地方可以和面试官事先沟通一下,pre check overflow
            if (res > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return sign ? res : -res;
    }
}
