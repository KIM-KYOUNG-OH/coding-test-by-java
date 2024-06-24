package programmers_2024.stackQueue;

import java.util.ArrayList;
import java.util.List;

public class HateSameNumber {
    public int[] solution(int []arr) {
        List<Integer> q = new ArrayList<>();
        for (int num : arr) {
            if (q.size() == 0) {
                q.add(num);
                continue;
            }

            if (q.get(q.size() - 1) == num) {
                continue;
            } else {
                q.add(num);
            }
        }

        return q.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        HateSameNumber s = new HateSameNumber();
        s.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
    }
}
