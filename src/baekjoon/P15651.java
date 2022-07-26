package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P15651 {
    static int[] nums;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        nums = new int[n + 1];

        for(int i = 1; i < n + 1; i++) {
            nums[i] = i;
        }

        recursive(new ArrayList<>(), n, m);

        br.close();
        bw.close();
    }

    private static void recursive(List<Integer> list, int n, int m) throws IOException {
        if(list.size() >= m) {
            for(int i = 0; i < list.size(); i++) {
                if(i == list.size() - 1) {
                    bw.write(list.get(i) + "\n");
                } else {
                    bw.write(list.get(i) + " ");
                }
            }
            return;
        }

        for(int i = 1; i < n + 1; i++) {
            list.add(nums[i]);
            recursive(list, n, m);
            list.remove(list.size() - 1);
        }
    }
}
