package programmers.bruteforce;

import java.util.*;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int area = brown + yellow;

        List<int[]> possibleCases = new ArrayList<>();
        for(int i = 3; i < (area / 2) + 1; i++) {
            if ((area % i) == 0) {
                int[] cas = new int[2];  // {length, width}
                cas[0] = i;
                cas[1] = area / i;
                possibleCases.add(cas);
            }
        }

        for (int[] pCase : possibleCases) {
            int brownCnt = pCase[0] * 2 + pCase[1] * 2 - 4;
            if (brownCnt == brown) {
                answer = new int[]{pCase[1], pCase[0]};
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Carpet s = new Carpet();
        System.out.println(s.solution(10, 2));
    }
}
