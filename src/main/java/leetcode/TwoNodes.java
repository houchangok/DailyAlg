package leetcode;

public class TwoNodes {

    public static void main(String[] args) {
        TwoNodes twoNodes = new TwoNodes();
        //构建l1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        //构建l2
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = twoNodes.addTwoNodes(l1, l2);
        while (res.next!= null) {
            System.out.print(res.next.val + "--->");
            res = res.next;
        }
    }


    public ListNode addTwoNodes(ListNode l1, ListNode l2) {
        //结果列表的头节点
        ListNode res = new ListNode(-1);
        //尾节点
        ListNode tail = res;
        //进位值
        int cary = 0;
        while (l1 != null || l2 != null || cary != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            tail.next = new ListNode((x + y + cary) % 10);
            //进位值，
            cary = (x + y + cary) / 10;
            tail = tail.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res;
    }

}

/**
 * 节点定义
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}