package lagou.alg.heap;

public class Sink {
    // 上浮
    private void swim(int i, int[] a) {
        int t = a[i];
        int par = 0;
        // 如果还存在父结点
        // 由于我们的下标是从0开始
        // 0结点没有父结点
        while (i > 0) {
            par = (i - 1) >> 1;
            // 如果父结点比t值小
            if (a[par] < t) {
                // 那么向下移动父结点的值。
                a[i] = a[par];
                i = par;
            } else {
                break;
            }
        }
        a[i] = t;
    }
}
