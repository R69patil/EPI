package Arrays;
import java.util.*;

public class computexmax {
    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;

        for (Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // Example stock prices
        List<Double> stockPrices = Arrays.asList(100.0, 180.0, 260.0, 310.0, 40.0, 535.0, 695.0);

        // Compute maximum profit
        double maxProfit = computeMaxProfit(stockPrices);

        // Display result
        System.out.println("Maximum possible profit: " + maxProfit);
    }
}
