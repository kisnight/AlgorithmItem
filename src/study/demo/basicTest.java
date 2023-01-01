package study.demo;

import org.junit.Test;

import java.util.*;
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
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        HashMap<String, String> map = new HashMap<>();
        treeMap.put(2, "books");
        treeMap.put(1, "concurrent");
        treeMap.put(3, "a lock");

        map.put("bob", "books");
        map.put("c", "concurrent");
        map.put("a", "a lock");
        List<Integer> list = new ArrayList<>(treeMap.keySet());
        System.out.println(list);
        System.out.println(treeMap);
        System.out.println(map);

        StringBuffer sb = new StringBuffer();

        System.out.println("".equals("234"));
        String s = "23";
        String c = "23";
        System.out.println(s.hashCode());
        System.out.println(c.hashCode());

        List<Integer> asa = Arrays.asList(1, 3, 8, 12, 15, 18, 20, 25);
        System.out.println("中间数据：" + getRangeOfValue(9, asa));
    }

    private List<Integer> getRangeOfValue(Integer val, List<Integer> keyList) {
        List<Integer> valRange = new ArrayList<>();
        int low = 0;
        int high = keyList.size() -1;
        while(high != low + 1) {
            int mid = (low + high) / 2;
            if (keyList.get(mid) > val) {
                high = mid;
            }else {
                low = mid;
            }
        }

        valRange.add(low);
        valRange.add(high);
        return valRange;
    }

}




