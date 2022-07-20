package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> nums = new ArrayList<>();
        for(int i = 123; i <= 987; i++) {
            String temp = String.valueOf(i);
            if(isPossible(temp)) nums.add(temp);
        }

        Collections.sort(nums);

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        List<BaseBallData> cases = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            cases.add(new BaseBallData(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        }

        for (String num : nums) {
            int passCnt = 0;
            for (BaseBallData bCase : cases) {
                String number = bCase.number;

                int strikeCnt = countStrike(number, num);

                int ballCnt = countBall(number, num);

                if(strikeCnt == bCase.strike && ballCnt == bCase.ball) {
                    passCnt++;
                } else {
                    break;
                }
            }

            if(passCnt == cases.size()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(String number) {
        if(number.indexOf('0') != -1) return false;

        Set<Character> chars = new HashSet<>();
        for (char c : number.toCharArray()) {
            chars.add(c);
        }

        return chars.size() == 3;
    }

    private static int countBall(String num, String target) {
        int ball = 0;
        for(int i = 0; i < 3; i++) {
            if(num.charAt(i) == target.charAt((i + 1) % 3) || num.charAt(i) == target.charAt((i + 2) % 3)) {
                ball++;
            }
        }

        return ball;
    }

    private static int countStrike(String num, String target) {
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            if(num.charAt(i) == target.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private static class BaseBallData {
        String number;
        int strike;
        int ball;

        public BaseBallData(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
