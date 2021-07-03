package lagou.alg.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProirityQueue {
    public static void main(String[] args) {
        int[] res = getKminElements(new int[]{9, 3, 2, 8, 1, 7, 5, 6, 4}, 4);
        for (int element : res)
            System.out.print(element + " ");
    }

    public static int[] getKminElements(int[] arr, int k) {
        //处理边界
        if (k <= 0 || arr == null || arr.length == 0) {
            return new int[0];
        }
        //构建大堆
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int a : arr) {
            queue.offer(a);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (int x : queue) {
            res[i++] = x;
        }

        return res;

    }
}
