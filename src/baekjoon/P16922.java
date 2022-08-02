package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P16922 {
    static int n;
    static int[] nums = new int[]{1, 5, 10, 50};
    static Map<Integer, Integer> map = new HashMap<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;

        recursive(0, 0, 0);

        System.out.println(answer);

        br.close();
    }

    private static void recursive(int start, int sum, int depth) {
        if(depth == n) {
            if(!map.containsKey(sum)) {
                map.put(sum, 1);
                answer++;
            }
            return;
        }

        for(int i = start; i < 4; i++) {
            recursive(i, sum + nums[i], depth + 1);
        }
    }
}
