package programmers;

import java.util.*;

public class LottoBestRankingAndWorstRanking {
    public int[] solution(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> lottosMap = new HashMap<>();
        int zeroCnt = 0;

        for(int lotto: lottos) {
            if(lotto == 0) {
                zeroCnt++;
                continue;
            }
            lottosMap.put(lotto, true);
        }

        int sameCnt = 0;
        for(int winNum: win_nums) {
            if(lottosMap.containsKey(winNum)) sameCnt++;
        }

        int maxRank = 7 - (sameCnt + zeroCnt);
        int minRank = 7 - sameCnt;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[]{maxRank, minRank};
    }
}
