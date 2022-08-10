package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int startSec = convertToSecond(s[0]);
        int endSec = convertToSecond(s[1]);
        int quitSec = convertToSecond(s[2]);
        Map<String, Integer> inHistory = new HashMap<>();
        Map<String, Integer> outHistory = new HashMap<>();

        String log;
        while((log = br.readLine()) != null) {
            String[] logArr = log.split(" ");
            int time = convertToSecond(logArr[0]);
            String name = logArr[1];

            if(0 <= time && time <= startSec) {
                if(!inHistory.containsKey(name)) {
                    inHistory.put(name, time);
                }
            } else if(endSec <= time && time <= quitSec) {
                if(!outHistory.containsKey(name)) {
                    outHistory.put(name, time);
                }
            }
        }

        int answer = 0;
        for (String name : inHistory.keySet()) {
            if(outHistory.containsKey(name)) answer++;
        }

        System.out.println(answer);

        br.close();
    }

    private static int convertToSecond(String time) {
        int[] times = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return times[0] * 60 + times[1];
    }
}
