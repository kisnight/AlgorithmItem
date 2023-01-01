package LinkedList.合并两个有序链表_21_repeat;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Definition for singly-linked list.
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

public class mergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while (list1 != null || list2 != null) {
            if(list1 != null) {
                list.add(list1.val);
                list1 = list1.next;
            }
            if(list2 != null) {
                list.add(list2.val);
                list2 = list2.next;
            }
        }

        Collections.sort(list);
        //这里最关键的是新建了一个值为-1的头
        ListNode preNode = new ListNode(-1);
        //又新建了一个头结点来等于preNode，后面就直接对pre进行操作
        ListNode pre = preNode;
        for (Integer item : list) {
            ListNode newNode = new ListNode(item);
            pre.next = newNode;
            pre = pre.next;
        }
        preNode = preNode.next;
        return preNode;
    }
}
