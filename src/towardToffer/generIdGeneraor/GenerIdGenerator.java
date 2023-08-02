package towardToffer.generIdGeneraor;

import java.util.concurrent.atomic.AtomicInteger;

public class GenerIdGenerator {
    private static final  String PREFIX = "GENE";
    private static AtomicInteger counter = new AtomicInteger(0);


    public static String generateGeneId() {
        int geneNum = counter.incrementAndGet();
        String geneId = String.format("%s%04d", PREFIX, geneNum);
        return geneId;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i ++) {
            Thread threadTemp = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int j = 0; j < 100; j ++) {
                    String geneId = generateGeneId();
                    System.out.println(geneId);
                }
            }
            });

            threadTemp.start();
        }
    }
}
