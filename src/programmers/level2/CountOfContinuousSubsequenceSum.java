package programmers.level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountOfContinuousSubsequenceSum {
    public int solution(int[] elements) {
        List<Integer> list = new ArrayList<>();
        for (int e : elements) {
            list.add(e);
        }
        for (int e : elements) {
            list.add(e);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j <= elements.length; j++) {
                int sum = 0;
                for(int k = j; k < j + i; k++) {
                    sum += list.get(k);
                }
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        CountOfContinuousSubsequenceSum s = new CountOfContinuousSubsequenceSum();
        s.solution(new int[]{7,9,1,1,4});
    }
}
