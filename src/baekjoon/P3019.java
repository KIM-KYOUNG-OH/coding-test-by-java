package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P3019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int c = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        int[] block = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        if (p == 1) {
            // 세로
            answer += c;

            // 가로
            for(int i = 0; i <= c - 4; i++) {
                int startHeight = block[i];
                boolean isPossible = true;
                for(int j = i + 1; j < i + 4; j++) {
                    if(block[j] != startHeight) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) answer++;
            }
        } else if(p == 2) {
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                boolean isPossible = true;
                for(int j = i + 1; j < i + 2; j++) {
                    if(block[j] != startHeight) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) answer++;
            }
        } else if(p == 3) {
            // 가로
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight && block[i + 2] == startHeight + 1) answer++;
            }

            // 세로
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight - 1) answer++;
            }
        } else if(p == 4) {
            // 가로
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight - 1 && block[i + 2] == startHeight - 1) answer++;
            }

            // 세로
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight + 1) answer++;
            }
        } else if(p == 5) {
            // 위
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight && block[i + 2] == startHeight) answer++;
            }

            // 오른
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight + 1) answer++;
            }

            // 아래
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight - 1 && block[i + 2] == startHeight) answer++;
            }

            // 왼
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight - 1) answer++;
            }
        } else if(p == 6) {
            // 오른쪽 회전 기준
            // 0도
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight && block[i + 2] == startHeight) answer++;
            }

            // 90도
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight) answer++;
            }

            // 180도
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight + 1 && block[i + 2] == startHeight + 1) answer++;
            }

            // 270도
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight - 2) answer++;
            }
        } else if(p == 7) {
            // 오른쪽 회전 기준
            // 0도
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight && block[i + 2] == startHeight) answer++;
            }

            // 90도
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight + 2) answer++;
            }

            // 180도
            for(int i = 0; i <= c - 3; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight && block[i + 2] == startHeight - 1) answer++;
            }

            // 270도
            for(int i = 0; i <= c - 2; i++) {
                int startHeight = block[i];
                if(block[i + 1] == startHeight) answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
