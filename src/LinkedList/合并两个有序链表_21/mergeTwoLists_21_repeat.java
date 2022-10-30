package LinkedList.合并两个有序链表_21;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mergeTwoLists_21_repeat {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            List<Integer> tempList = new ArrayList<>();
            while (list1 != null || list2 != null) {
                if(list1 != null) {
                    tempList.add(list1.val);
                    list1 = list1.next;
                }

                if(list2 != null) {
                    tempList.add(list2.val);
                    list2 = list2.next;
                }
            }

            Collections.sort(tempList);
            ListNode preNode = new ListNode(-1);
            ListNode pre = preNode;

            for(Integer item : tempList) {
                ListNode tempNode = new ListNode(item);
                pre.next = tempNode;
                pre = pre.next;
            }

            // 记住这里返回的是preNode.next 而不是preNode, 不然返回的结果就会多一个“-1”
            return preNode.next;
    }
}
