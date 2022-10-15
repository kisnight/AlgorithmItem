package study.demo.concurrenthashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {


    public static void main(String[] args) throws InterruptedException {

        Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
        for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                conMap.put(100L, "100");
                System.out.println("ADD:" + 100);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Iterator<Map.Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<Long, String> entry = iterator.next();
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();

        Thread.sleep(3000);
        System.out.println("--------");
        for (Map.Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
