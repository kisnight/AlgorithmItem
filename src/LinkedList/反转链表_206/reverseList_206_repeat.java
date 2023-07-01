package LinkedList.反转链表_206;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//class ListNode1 {
//    int val;
//    ListNode1 next;
//    ListNode1() {}
//    ListNode1(int val) { this.val = val; }
//    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
//}

public class reverseList_206_repeat {
    public ListNode1 reverseList(ListNode1 head) {
        if(head == null) {
            return head;
        }
        List<Integer> headList = new ArrayList<>();
        while (head != null) {
            headList.add(head.val);
            head = head.next;
        }

        ListNode1 preNode = new ListNode1(headList.get(0));
        ListNode1 pre = preNode;

        for(int i = 0; i < headList.size(); i ++) {
            if(i == 0) {
                continue;
            }
            ListNode1 node = new ListNode1(headList.get(i));
            pre.next = node;
            pre = pre.next;
        }
        return preNode;
    }
}
