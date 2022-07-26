package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15652 {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        nums = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            nums[i] = i;
        }

        recursive(1, new ArrayList<>(), n, m);
    }

    private static void recursive(int start, List<Integer> list, int n, int m) {
        if(list.size() >= m) {
            for(int i = 0; i < list.size(); i++) {
                if(i == list.size() - 1) {
                    System.out.print(list.get(i) + "\n");
                } else {
                    System.out.print(list.get(i) + " ");
                }
            }
            return;
        }

        for(int i = start; i < n + 1; i++) {
            list.add(nums[i]);
            recursive(i, list, n, m);
            list.remove(list.size() - 1);
        }
    }
}
