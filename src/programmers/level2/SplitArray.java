package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class SplitArray {
    public int[] solution(int n, long left, long right) {
        int[] arr = new int[(int) (right - left + 1)];
        int k = 0;
        for(long i = left; i <= right; i = i + 1L) {
            long row = i / n;
            long col = i % n;
            int val = (int) (Math.max(row, col) + 1L);
            arr[k++] = val;
        }

        return arr;
    }
}
