package programmers.stackAndQueue;

import java.util.*;

public class StockCost {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int period = 0;  // 떨어지지 않은 기간
            for( int j = i + 1; j < prices.length; j++) {
                period++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = period;
        }

        return answer;
    }
}
