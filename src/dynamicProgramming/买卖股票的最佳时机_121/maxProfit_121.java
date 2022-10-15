package dynamicProgramming.买卖股票的最佳时机_121;

public class maxProfit_121 {
    public int maxProfit(int[] prices) {
        // 最小价格的初始值等于prices数组的0号元素；
        int minPrice = prices[0];
        // 最大利润值的初始化等于0；
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i ++)  {
            // 遍历每天的价格数组prices[], 总的最小的价格肯定是当天的价格与之前最小的价格的最小值
            minPrice = Math.min(minPrice, prices[i]);
            // 而最大的利润肯定是当天的价格减去当天最小价格 和 之前最大利润的最大值
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
