package lagou.alg.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 假设你正在玩跳跃游戏，从低处往高处跳的时候，可以有两种方法。
 * <p>
 * 方法一：塞砖块，但是你拥有砖块数是有限制的。为了简单起见，高度差就是你需要砖块数。
 * <p>
 * 方法二：用梯子，梯子可以无视高度差（你可以认为再高也能爬上去），但是梯子的个数是有限的(一个只能用一次)。
 * <p>
 * 其他无论是平着跳，还是从高处往低处跳，不需要借助什么就可以完成（在这道题中我们默认无论从多高跳下来，也摔不死）。
 * <p>
 * 给你一个数组，用来表示不同的高度。假设你总是站在 index = 0 的高度开始。那么请问，你最远能跳到哪里?
 * <p>
 * 输入：[3, 1, 6, 20, 10, 20], bricks = 5, landers = 1
 * <p>
 * 输出：4
 * 拼多多面试题
 */
public class JumpGame {
    public static void main(String[] args) {

        System.out.println(furthestBuilding(new int[]{3, 1, 6, 20, 10, 20}, 5, 1));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 注意处理非法输入
        if (heights == null || heights.length == 0) {
            return -1;
        }
        // 记录落并的小本子: 最大堆
        Queue<Integer> Q = new PriorityQueue<>((v1, v2) -> v2 - v1);
        int qSum = 0;
        int lastPos = 0;
        int preHeight = heights[0];
        for (int i = 1; i < heights.length; i++) {
            final int curHeight = heights[i];
            // 如果是从高处往低处跳
            if (preHeight >= curHeight) {
                lastPos = i;
            } else {
                // 如果是低处往高处跳
                final int delta = curHeight - preHeight;
                // 拿到高度的落差
                // 写到小本子上
                Q.offer(delta);
                qSum += delta;
                // 如果小本子上的总和比砖块多了
                // 并且还有梯子
                while (qSum > bricks && ladders > 0) {
                    // 需要用梯子把最大的落差给抵消掉
                    qSum -= Q.peek();
                    Q.poll();
                    ladders--;
                }
                // 看看经过一番处理之后，还能不能跳到i这个位置
                if (qSum <= bricks) {
                    lastPos = i;
                } else {
                    // 如果经过一番处理之后，还是不能跳
                    // 看来不能跳到i了
                    // 跳出循环!
                    break;
                }
            }
            // 更新位置的高度
            preHeight = curHeight;
        }
        return lastPos;
    }
}
