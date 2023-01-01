package LinkedList.环形链表_141;


/*
# 思路
1、可以使用快慢指针法，分别定义fast和slow指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，
2、如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
 */

public class hasCycle_141_repeat {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}
