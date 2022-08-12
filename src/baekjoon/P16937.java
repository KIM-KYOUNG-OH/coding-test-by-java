package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int n = Integer.parseInt(br.readLine());
        int[][] sticker = new int[n][2];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            sticker[i][0] = Integer.parseInt(ss[0]);
            sticker[i][1] = Integer.parseInt(ss[1]);
        }

//        for(int i = 0; i < n; i++) {
//            System.out.println(sticker[i][0] + " " + sticker[i][1]);
//        }

        int max = 0;
        for(int i = 0; i < n - 1; i++) {
            int a1 = sticker[i][0];
            int b1 = sticker[i][1];
            for(int j = i + 1; j < n; j++) {
                int a2 = sticker[j][0];
                int b2 = sticker[j][1];

                // 회전 없음
                if(isPossible(a1, b1, h, w)) {
                    // 위 직사각형
                    if(isPossible(a2, b2, h, w - b1)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                    // 아래 직사각형
                    if(isPossible(a2, b2, h - a1, w)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                }

                // 1 회전
                if(isPossible(b1, a1, h, w)) {
                    // 위 직사각형
                    if(isPossible(a2, b2, h, w - a1)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                    // 아래 직사각형
                    if(isPossible(a2, b2, h - b1, w)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                }

                // 2 회전
                if(isPossible(a1, b1, h, w)) {
                    // 위 직사각형
                    if(isPossible(b2, a2, h, w - b1)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                    // 아래 직사각형
                    if(isPossible(b2, a2, h - a1, w)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                }

                // 1, 2 회전
                if(isPossible(b1, a1, h, w)) {
                    // 위 직사각형
                    if(isPossible(b2, a2, h, w - a1)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                    // 아래 직사각형
                    if(isPossible(b2, a2, h - b1, w)) {
                        max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
                    }
                }
            }
        }

        System.out.println(max);

        br.close();
    }

    // a * b 가 h * w 안에 포함될 수 있는가?
    private static boolean isPossible(int a, int b, int h, int w) {
        if(a > h) return false;
        if(b > w) return false;
        if(a * b > h * w) return false;
        return true;
    }
}
