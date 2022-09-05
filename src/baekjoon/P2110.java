package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2110 {
    static int n;
    static int c;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        houses = new int[n];
        for(int i = 0; i < n; i++) {
            int position = Integer.parseInt(br.readLine());
            houses[i] = position;
        }

        Arrays.sort(houses);

        int maxDistance = binarySearch();

        System.out.println(maxDistance);

        br.close();
    }

    private static int binarySearch() {
        int left = 1;
        int right = houses[n - 1] - houses[0];
        int max = 0;
        while (left <= right) {
            int mid = (left + right) / 2;  // 최소 거리

            int cnt = getCnt(mid);

            if(cnt >= c) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return max;
    }

    private static int getCnt(int mid) {
        int cnt = 1;
        int prevPos = houses[0];
        for (int i = 1; i < houses.length; i++) {
            int cur = houses[i];
            if (cur - prevPos >= mid) {
                cnt++;
                prevPos = cur;
            }
        }
        return cnt;
    }
}
