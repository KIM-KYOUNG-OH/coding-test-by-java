package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coordinate> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Coordinate(s[1], s[0]));
        }

        int[] distances = new int[n - 1];
        int total = 0;
        for(int i = 0; i < n - 1; i++) {
            Coordinate cur = list.get(i);
            Coordinate next = list.get(i + 1);
            int distance = manhattan(cur, next);
            distances[i] = distance;
            total += distance;
        }

        int max = 0;
        for(int i = 0; i < n - 2; i++) {
            Coordinate cur = list.get(i);
            Coordinate nextNext = list.get(i + 2);
            int skipCaseDistance = manhattan(nextNext, cur);
            int distance = distances[i] + distances[i + 1];
            max = Math.max(max, distance - skipCaseDistance);
        }

        System.out.println(total - max);

        br.close();
    }

    private static int manhattan(Coordinate cur, Coordinate next) {
        return Math.abs(cur.y - next.y) + Math.abs(cur.x - next.x);
    }

    private static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
