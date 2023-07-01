package LinkedList.删除链表的倒数第N个结点_19_repeat;

import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd_19_repeat2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
            1、先用一个List集合将链表中的所有元素都存储起来
            2、然后直接在List集合里面进行元素的删除
            3、重新构建链表
         */
        List<ListNode> tempNodeList = new ArrayList<>();
        while (head!= null) {
            tempNodeList.add(head);
            head = head.next;
        }

        int deletNum = tempNodeList.size() - n;
        tempNodeList.remove(deletNum);

        ListNode headNode = new ListNode( -1);
        ListNode preNode = headNode;
        for(ListNode node : tempNodeList) {
            preNode.next = node;
            preNode = preNode.next;
        }

        return headNode.next;
    }

}
