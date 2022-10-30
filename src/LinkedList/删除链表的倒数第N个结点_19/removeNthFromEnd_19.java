package LinkedList.删除链表的倒数第N个结点_19;

import java.util.ArrayList;
import java.util.List;

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

public class removeNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> list =new ArrayList<ListNode>();
        ListNode rs = head;
        while(head !=null){
            list.add(head);
            head=head.next;
        }
        int index =list.size()-n;
        if(index==0){
            return rs.next;
        }
        ListNode last =list.get(index -1);
        ListNode cur =list.get(index);
        last.next= cur.next;
        return rs;
    }

}
