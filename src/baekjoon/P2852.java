package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Memo[] memos = new Memo[n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int team = Integer.parseInt(s[0]);
            String[] ss = s[1].split(":");
            int minute = Integer.parseInt(ss[0]);
            int second = Integer.parseInt(ss[1]);
            memos[i] = new Memo(team, minute, second);
        }

        int prev = 0;
        int team1Grade = 0;
        int team2Grade = 0;
        int team1WinningTime = 0;
        int team2WinningTime = 0;
        for (Memo memo : memos) {
            int cur = memo.minute * 60 + memo.second;
            if(team1Grade > team2Grade) {
                team1WinningTime += cur - prev;
            } else if(team1Grade < team2Grade) {
                team2WinningTime += cur - prev;
            }
            prev = cur;

            if(memo.team == 1) {
                team1Grade++;
            } else {
                team2Grade++;
            }
        }

        int endTime = 48 * 60;
        if(team1Grade > team2Grade) {
            team1WinningTime += endTime - prev;
        } else if(team1Grade < team2Grade) {
            team2WinningTime += endTime - prev;
        }

        System.out.println(getTime(team1WinningTime));
        System.out.println(getTime(team2WinningTime));

        br.close();
    }

    private static String getTime(int second) {
        int m = second / 60;
        int s = second % 60;
        StringBuilder sb = new StringBuilder();
        if(m == 0) {
            sb.append("00:");
        } else if(m < 10) {
            sb.append("0");
            sb.append(m);
            sb.append(":");
        } else {
            sb.append(m);
            sb.append(":");
        }

        if(s == 0) {
            sb.append("00");
        } else if(s < 10) {
            sb.append("0");
            sb.append(s);
        } else {
            sb.append(s);
        }

        return sb.toString();
    }

    private static class Memo {
        int team;
        int minute;
        int second;

        public Memo(int team, int minute, int second) {
            this.team = team;
            this.minute = minute;
            this.second = second;
        }
    }
}
