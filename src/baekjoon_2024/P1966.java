package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            int m = s[1];
            int[] priorities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> numbers = new HashMap<>();
            for (int priority : priorities) {
                numbers.put(priority, numbers.getOrDefault(priority, 0) + 1);
            }

        }
    }
}
