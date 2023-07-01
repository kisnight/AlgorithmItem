package towardToffer.printListFromTailToHead;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

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

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(listNode == null) {
            return arr;
        }
        Stack<Integer> tempStack = new Stack<>();
        while (listNode != null) {
            tempStack.push(listNode.val);
            listNode = listNode.next;
        }
        if(!tempStack.isEmpty()) {
            arr.add(tempStack.pop());
        }
        return arr;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(listNode == null) {
            return (ArrayList<Integer>) arr;
        }

        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }
        Collections.sort(arr);
        return arr;
    }
}
