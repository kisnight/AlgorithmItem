package LinkedList.删除链表的倒数第N个结点_19;

import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd_19_repeat {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
            1、先用一个List集合将链表中的所有元素都存储起来
            2、然后直接在List集合里面进行元素的删除
            3、重新构建链表
         */

        List<Integer> tempList = new ArrayList<>();
        while (head != null) {
            tempList.add(head.val);
            head = head.next;
        }
        // 求出要删除的元素下标；
        int deletIndex = tempList.size() - n;
        tempList.remove(deletIndex);
        // 注意这里需要构建一个头节点
        ListNode preNode = new ListNode(-1);
        ListNode pre = preNode;
        for(Integer item : tempList) {
            ListNode itemNode = new ListNode(item);
            pre.next = itemNode;
            pre = pre.next;
        }
        // 这里返回的是preNode.next而不是preNode，必须要很注意
        return preNode.next;
    }

}
