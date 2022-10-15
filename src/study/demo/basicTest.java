package study.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class basicTest {
    @Test
    public void Test() {
        String a = "123";
        StringBuilder b = new StringBuilder();
        StringBuffer c = new StringBuffer();
        System.out.println("");
    }

    @Test
    public void concurrentHashMapTest() throws InterruptedException {
        // 使用ConcurrentHashMap操作
        ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(i + "", i + "");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(i + "", i + "");
            }
        });
        t1.start();
        t2.start();
        // 让两个线程有机会将数据添加完毕
        Thread.sleep(1000);

        // 遍历集合: 我们发现很对null
        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        }
    }

    @Test
    public void treeMapTest() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        HashMap<String, String> map = new HashMap<>();
        treeMap.put("bob", "books");
        treeMap.put("c", "concurrent");
        treeMap.put("a", "a lock");

        map.put("bob", "books");
        map.put("c", "concurrent");
        map.put("a", "a lock");
        System.out.println(treeMap);
        System.out.println(map);

        StringBuffer sb = new StringBuffer();

    }


}




