package LinkedList.反转链表_206;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

public class reverseList_206 {
    public ListNode1 reverseList(ListNode1 head) {
        if(head == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode1 tempNode = head;
        while(tempNode != null) {
            list.add(tempNode.val);
            tempNode = tempNode.next;
        }

        Collections.reverse(list);

        //这里最关键的是新建了一个值为-1的头
        ListNode1 preNode = new ListNode1(list.get(0));
        //又新建了一个头结点来等于preNode，后面就直接对pre进行操作
        ListNode1 pre = preNode;
        for (int i = 0; i < list.size(); i++ ) {
            //这里和之前的合并多个链表有点不一样
            if(i == 0) {
                continue;
            }
            ListNode1 newNode = new ListNode1(list.get(i));
            pre.next = newNode;
            pre = pre.next;
        }

        return preNode;
    }
}
