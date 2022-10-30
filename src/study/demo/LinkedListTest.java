package study.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListTest{
    public static void main(String[] args) {
        LinkedList<Integer> lList = new LinkedList<Integer>();
        Set<String> set = new HashSet<>();

        lList.add(1);
        lList.add(2);
        lList.add(3);
        lList.add(4);
        lList.add(5);
        lList.add(1);

        set.add("5");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("1");

        System.out.println("链表的第一个元素是 : " + lList.getFirst());
        System.out.println("链表最后一个元素是 : " + lList.getLast());
    }
}
