package lagou.alg.heap;

public class Kmin_1 {


    private int[] a = null;
    private int n = 0;


    public static void main(String[] args) {
        Kmin_1 heap_1 = new Kmin_1();
        int[] res = heap_1.getLeastNumbers(new int[]{9, 3, 2, 8, 1, 7, 5, 6, 4}, 4);
        for (int element : res)
            System.out.print(element+" ");
    }

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k <= 0 || arr == null || arr.length == 0) {
            return new int[0];
        }
        // 初始化堆, 注意大小要为k + 1
        a = new int[k + 1];
        n = 0;
        for (int x : arr) {
            // 首先将元素压入堆中
            // 如果堆中已经有k个元素
            // 此时压入，会有k+1个元素，
            // 所以初始化时，申请数组大小需要为k+1
            push(x);
            // 如果堆中元素多于k个，那么扔掉最大的元素
            if (size() > k) {
                pop();
            }
        }
        // 返回最小的k个数
        int[] ans = new int[k];
        int i = 0;
        while (size() > 0) {
            ans[i++] = pop();
        }
        return ans;
    }


    // 下沉
    public void sink(int i) {
        int j = 0;
        int t = a[i];
        // 找到i结点的左子结点
        while ((j = (i << 1) + 1) < n) {
            // j < n - 1判断是否有右子结点
            // 如果有，并且右子结点更大，那么
            // j指向右子结点
            if (j < n - 1 && a[j] < a[j + 1]) {
                j++;
            }
            // 如果子结点比t大
            // 那么t的位置还需要往后排
            if (a[j] > t) {
                a[i] = a[j];
                i = j;
            } else {
                // 找到了t的位置
                // 此时t是大于所有的子结点的
                break;
            }
        }
        // 将t放在找到的位置那里
        a[i] = t;
    }

    // 上浮
    public void swim(int i) {
        int t = a[i];
        int par = 0;
        // 如果还存在父结点
        while (i > 0 && (par = (i - 1) >> 1) != i) {
            // 如果父结点比t值小
            if (a[par] < t) {
                a[i] = a[par];
                i = par;
            } else {
                break;
            }
        }
        a[i] = t;
    }

    public void push(int v) {
        // push是先把元素追加到数组尾巴上，然后再执行上浮操作
        a[n++] = v;
        swim(n - 1);
    }

    public int pop() {
        //先取根元素
        int ret = a[0];
        //将数组末尾放入根节点
        a[0] = a[--n];
        //下沉
        sink(0);
        return ret;
    }

    public int size() {
        return n;
    }
}
