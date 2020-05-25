import java.util.*;
import java.io.*;

class Main {

    public static String TimeDifference(String[] strArr) {
        // code goes here
        System.out.println(Math.abs(calculateDuration(getLowestTimeFrames(strArr))));
        return strArr[0];
    }

    public static int calculateDuration(TreeMap<Integer, Integer> input) {
        int minimumFirstValue = input.get(input.firstKey());
        int minimumSecondKey = input.get(input.keySet().toArray()[1]);

        return minimumFirstValue - minimumSecondKey;
    }

    public static TreeMap<Integer, Integer> getLowestTimeFrames(String[] input) {
        TreeMap<Integer, Integer> HHMMtoMap = new TreeMap();
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].replaceAll("am", "");
            input[i] = input[i].replaceAll("pm", "");
            String[] HHMM = input[i].split(":");
            HHMMtoMap.put(Integer.parseInt(HHMM[0]), Integer.parseInt(HHMM[1]));
        }
        System.out.print(HHMMtoMap);
        return HHMMtoMap;
    }

    /*public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        //System.out.print();
        TimeDifference(s.nextLine().split(","));
    }*/

    public static int CoinDeterminer(int[] coins, int coinsize, int num) {
        // code goes here
        if (num == 0) return num;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coinsize; i++) {
            if (coins[i] <= num) {
                int temp = CoinDeterminer(coins, coinsize, num - coins[i]);
                if (temp != Integer.MAX_VALUE && temp + 1 < result) {
                    result = temp + 1;
                }
            }
        }
        return result;
    }

    static int maxProfit(int[] price,
                         int n,
                         int k) {

        int[][] profit = new int[k + 1][n + 1];

        // For day 0, you can't
        // earn money irrespective
        // of how many times you trade
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't
        // do any transation
        // (i.e. k =0)
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;

        // fill the table in
        // bottom-up fashion
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int max_so_far = 0;

                for (int m = 0; m < j; m++)
                    max_so_far = Math.max(max_so_far, price[j] -
                            price[m] + profit[i - 1][m]);

                profit[i][j] = Math.max(profit[i][j - 1],
                        max_so_far);
            }
        }

        return profit[k][n - 1];
    }

    public static int calculateMaxProfit(int[] arr) {
        int lowestPriceTillThatDay = arr[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int profit = 0;
            if (arr[i] > lowestPriceTillThatDay) {
                profit = arr[i] - lowestPriceTillThatDay;
                // Check for maxProfit
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else { // update lowest Price till day
                lowestPriceTillThatDay = arr[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // keep this function call here
        /*Scanner s = new Scanner(System.in);
        int[] availableCoins = {1, 5, 7, 9, 11};
        System.out.print(CoinDeterminer(availableCoins, availableCoins.length, 8));*/

        int k = 2;
        int[] price = {14, 20, 4, 12, 5, 11};
        int n = price.length;
        System.out.println("Maximum profit is: " +
                maxProfit(price, n, k));
        System.out.println(calculateMaxProfit(price));
    }



}