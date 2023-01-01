package LinkedList.环形链表_141_repeat;


/*
# 思路
1、可以使用快慢指针法，分别定义fast和slow指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，
2、如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
public class hasCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //如果有环的话，那这个while会一直循环下去；
        while (fast != null && fast.next != null) {
            /*
            为什么上面的while语句中，会有fast.next!= null，因为当fast是倒数第二个，
            fast.next是倒数第一个的时候，只有fast.next != null才能满足有坏
             */
            //快指针每次运行两步
            fast = fast.next.next;
            //慢指针每次运行一步
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
