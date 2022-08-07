package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P14719 {
    static int h;
    static int w;
    static int[] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);
        blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;

        // 맨 양쪽 끝을 제외하고 빗물이 쌓일 수 있는 양 계산
        for(int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            // 왼쪽으로 가장 긴 block
            for(int j = 0; j <= i; j++) {
                left = Math.max(left, blocks[j]);
            }

            // 오른쪽으로 가장 긴 block
            for (int j = i; j < w; j++) {
                right = Math.max(right, blocks[j]);
            }

            // min(왼긴 block, 오긴 block) - block[i]
            int area = Math.min(left, right) - blocks[i];
            answer += area;
        }

        System.out.println(answer);

        br.close();
    }
}
