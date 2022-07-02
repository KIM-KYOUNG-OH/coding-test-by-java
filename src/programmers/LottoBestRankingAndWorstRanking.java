package programmers;

public class LottoBestRankingAndWorstRanking {
//    public int[] solution(int[] lottos, int[] win_nums) {
//        Map<Integer, Boolean> lottosMap = new HashMap<>();
//        int zeroCnt = 0;
//
//        for(int lotto: lottos) {
//            if(lotto == 0) {
//                zeroCnt++;
//                continue;
//            }
//            lottosMap.put(lotto, true);
//        }
//
//        int sameCnt = 0;
//        for(int winNum: win_nums) {
//            if(lottosMap.containsKey(winNum)) sameCnt++;
//        }
//
//        int maxRank = 7 - (sameCnt + zeroCnt);
//        int minRank = 7 - sameCnt;
//        if(maxRank > 6) maxRank = 6;
//        if(minRank > 6) minRank = 6;
//
//        return new int[]{maxRank, minRank};
//    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if(lotto == 0) {
                zeroCnt++;
            }
        }

        int correctCnt = 0;
        for (int num : win_nums) {
            for (int lotto : lottos) {
                if(num == lotto) {
                    correctCnt++;
                    break;
                }
            }
        }

        int max = 7 - (correctCnt + zeroCnt);
        int min = 7 - correctCnt;
        if(max == 7) max--;
        if(min == 7) min--;

        int[] answer = new int[]{max, min};

        return answer;
    }
}
