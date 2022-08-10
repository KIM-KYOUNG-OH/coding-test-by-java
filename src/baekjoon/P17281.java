package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P17281 {
    static int n;
    static int[][] hits;

    static int answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hits = new int[n + 1][10];
        for(int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 1; j <= 9; j++) {
                hits[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        answer = 0;
        visited = new boolean[10];
        recursive(new ArrayList<>());

        System.out.println(answer);

        br.close();
    }

    private static void recursive(List<Integer> playSequence) {
        if(playSequence.size() >= 9) {
            int grade = playGame(playSequence);

            // 점수 최대값 answer 에 업데이트
            answer = Math.max(answer, grade);
            return;
        }

        if(playSequence.size() == 3) {
            playSequence.add(1);
            recursive(playSequence);
            playSequence.remove(playSequence.size() - 1);
        } else {
            for(int i = 2; i < 10; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    playSequence.add(i);
                    recursive(playSequence);
                    playSequence.remove(playSequence.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static int playGame(List<Integer> playSequence) {
        int play = 0;
        int inning = 1;
        int grade = 0;
        boolean[] home;
        int out;

        while (inning <= n) {
            out = 0;
            home = new boolean[4];
            while(out < 3) {
                int player = playSequence.get(play);
                int hit = hits[inning][player];

                if(hit == 0) {
                    out++;
                } else if(hit == 1) {
                    home[0] = true;
                    grade += forwardOne(home);
                } else if(hit == 2) {
                    home[0] = true;
                    grade += forwardTwo(home);
                } else if(hit == 3) {
                    home[0] = true;
                    grade += forwardThree(home);
                } else {
                    home[0] = true;
                    grade += homeRun(home);
                    home = new boolean[4];
                }

                play = next(play);
            }

            inning++;
        }

        return grade;
    }

    private static int homeRun(boolean[] home) {
        int plusGrade = 0;
        for(int i = 3; i >= 0; i--) {
            if(home[i]) {
                plusGrade++;
            }
        }

        return plusGrade;
    }

    private static int forwardThree(boolean[] home) {
        int plusGrade = 0;
        for(int i = 3; i >= 0; i--) {
            if((i == 1 || i == 2 || i == 3) && home[i]) {
                home[i] = false;
                plusGrade++;
                continue;
            }

            if(home[i]) {
                home[i] = false;
                home[i + 3] = true;
            }
        }

        return plusGrade;
    }

    private static int forwardTwo(boolean[] home) {
        int plusGrade = 0;
        for(int i = 3; i >= 0; i--) {
            if((i == 2 || i == 3) && home[i]) {
                home[i] = false;
                plusGrade++;
                continue;
            }

            if(home[i]) {
                home[i] = false;
                home[i + 2] = true;
            }
        }

        return plusGrade;
    }

    private static int forwardOne(boolean[] home) {
        int plusGrade = 0;
        for(int i = 3; i >= 0; i--) {
            if(i == 3 && home[i]) {
                home[i] = false;
                plusGrade++;
                continue;
            }

            if(home[i]) {
                home[i] = false;
                home[i + 1] = true;
            }
        }

        return plusGrade;
    }

    private static int next(int play) {
        int result = play + 1;
        if(play >= 8) {
            return 0;
        }

        return result;
    }
}
