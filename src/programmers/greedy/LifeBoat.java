package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int coupleCnt = 0;

        // 최대 2명, 무게 제한
        int minPointer = 0;
        int maxPointer = people.length - 1;
        Arrays.sort(people);
        while(minPointer < maxPointer) {
            if(people[minPointer] + people[maxPointer] <= limit) {
                coupleCnt++;
                minPointer++;
            }
            maxPointer--;
        }

        return people.length - coupleCnt;
    }
}
