package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P17140 {
    static int r;
    static int c;
    static int k;
    static int[][] matrix;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        n = 3;
        m = 3;
        matrix = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                matrix[i + 1][j + 1] = Integer.parseInt(ss[j]);
            }
        }
        int time = 0;

        while(true) {
            if(r <= n && c <= m) {
                if(matrix[r][c] == k) break;
            }

            time++;
            if(time > 100) {
                System.out.println(-1);
                return;
            }

            if(n >= m) {
                functionR();
            } else {
                functionC();
            }
        }

        System.out.println(time);

        br.close();
    }

    private static void functionC() {  // 열 정렬
        int fixedN = 0;
        List<List<CallCount>> orders = new ArrayList<>();
        for(int j = 1; j <= m; j++) {
            List<CallCount> list = new ArrayList<>();
            Map<Integer, Integer> index = new HashMap<>();
            for(int i = 1; i <= n; i++) {
                if(matrix[i][j] == 0) continue;
                if(index.containsKey(matrix[i][j])) {
                    int idx = index.get(matrix[i][j]);
                    list.get(idx).count += 1;
                } else {
                    index.put(matrix[i][j], list.size());
                    list.add(new CallCount(matrix[i][j], 1));
                }
            }

            // 정렬
            list.sort(Comparator.comparing(CallCount::getCount).thenComparing(CallCount::getNum));

            orders.add(list);

            fixedN = Math.max(fixedN, list.size() * 2);
        }

        if(fixedN > 100) fixedN = 100;
        int[][] fixedMatrix = new int[fixedN + 1][m + 1];
        for(int i = 0; i < orders.size(); i++) {
            List<CallCount> cur = orders.get(i);
            for(int q = 0; q < cur.size(); q++) {
                if(q == 50) break;
                fixedMatrix[q * 2 + 1][i + 1] = cur.get(q).num;
                fixedMatrix[q * 2 + 2][i + 1] = cur.get(q).count;
            }
        }

        n = fixedN;
        matrix = fixedMatrix;
    }

    private static void functionR() {  // 행 정렬
        int fixedM = 0;
        List<List<CallCount>> orders = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            List<CallCount> list = new ArrayList<>();
            Map<Integer, Integer> index = new HashMap<>();
            for(int j = 1; j <= m; j++) {
                if(matrix[i][j] == 0) continue;
                if(index.containsKey(matrix[i][j])) {
                    int idx = index.get(matrix[i][j]);
                    list.get(idx).count += 1;
                } else {
                    index.put(matrix[i][j], list.size());
                    list.add(new CallCount(matrix[i][j], 1));
                }
            }

            // 정렬
            list.sort(Comparator.comparing(CallCount::getCount).thenComparing(CallCount::getNum));

            orders.add(list);

            fixedM = Math.max(fixedM, list.size() * 2);
        }

        if(fixedM > 100) fixedM = 100;
        int[][] fixedMatrix = new int[n + 1][fixedM + 1];
        for(int i = 0; i < orders.size(); i++) {
            int[] arr = new int[fixedM + 1];
            List<CallCount> cur = orders.get(i);
            for(int q = 0; q < cur.size(); q++) {
                if(q == 50) break;
                arr[2 * q + 1] = cur.get(q).num;
                arr[2 * q + 2] = cur.get(q).count;
            }

            fixedMatrix[i + 1] = arr;
        }

        m = fixedM;
        matrix = fixedMatrix;
    }

    private static class CallCount {
        int num;
        int count;

        public CallCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }
}
