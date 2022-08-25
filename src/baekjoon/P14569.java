package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14569 {
    static Class[] classes;
    static List<Map<Integer, Integer>> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        classes = new Class[n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int hour = Integer.parseInt(s[0]);
            int[] times = new int[hour];
            for(int j = 1; j < s.length; j++) {
                times[j - 1] = Integer.parseInt(s[j]);
            }
            classes[i] = new Class(hour, times);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Map<Integer, Integer> temp = new HashMap<>();
            for(int j = 1; j < s.length; j++) {
                temp.put(s[j], 0);
            }
            students.add(temp);
        }

        int[] answer = new int[m];
        for (Class curClass : classes) {
            for(int i = 0; i < students.size(); i++) {
                Map<Integer, Integer> map = students.get(i);
                boolean isIncluded = true;
                for (int time : curClass.times) {
                    if(!map.containsKey(time)) {
                        isIncluded = false;
                        break;
                    }
                }
                if(isIncluded) answer[i]++;
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }

        br.close();
    }

    public static class Class {
        int hour;
        int[] times;

        public Class(int hour, int[] times) {
            this.hour = hour;
            this.times = times;
        }
    }
}
