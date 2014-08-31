/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.*/

public class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++)
        {
            int buy = prices[i];
            for(int j=i+1; j<prices.length; j++)
            {
                int sell = prices[j];
                int profit = sell - buy;
                if(profit > maxProfit)
                {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
