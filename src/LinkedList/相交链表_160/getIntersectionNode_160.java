package LinkedList.相交链表_160;

//import LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

 /*
思路和算法
判断两个链表是否相交，可以使用哈希集合存储链表节点。
1、首先遍历链表headA，并将链表 headA 中的每个节点加入哈希集合中。
    然后遍历链表 headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
2、如果当前节点不在哈希集合中，则继续遍历下一个节点；
3、如果当前节点在哈希集合中，则后面的节点都在哈希集合中，即从当前节点开始的所有节点都在两个链表的相交部分，
    因此在链表 headB 中遍历到的第一个在哈希集合中的节点就是两个链表相交的节点，返回该节点。
4、如果链表 headB 中的所有节点都不在哈希集合中，则两个链表不相交，返回 null。
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
public class getIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode tempNode = headA;
        //首先遍历链表headA，并将链表headA 中的每个节点加入哈希集合中
        while(tempNode != null) {
            listNodeSet.add(tempNode);
            tempNode = tempNode.next;
        }

        tempNode = headB;
        //遍历链表headB，对于遍历到的每个节点，判断该节点是否在哈希集合中
        while(tempNode != null) {
            if(listNodeSet.contains(tempNode)) {
                return tempNode;
            }
            tempNode = tempNode.next;
        }

        return null;
    }
}
