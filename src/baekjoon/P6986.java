package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P6986 {
    static int n;
    static int k;
    static double[] grades;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        grades = new double[n];

        for(int i = 0; i < n; i++) {
            grades[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(grades);

        String sliceAverage = getSliceAverage();
        String correctionAverage = getCorrectionAverage();

        System.out.println(sliceAverage);
        System.out.println(correctionAverage);

        br.close();
    }

    private static String getCorrectionAverage() {
        double sum = 0;

        for(int i = 0; i < k; i++) {
            sum += grades[k];
        }

        for(int i = k; i < n - k; i++) {
            sum += grades[i];
        }

        for(int i = n - 1; i >= n - k; i--) {
            sum += grades[n - k - 1];
        }

        double avg = sum / n;
        return String.format("%.2f", avg);
    }

    private static String getSliceAverage() {
        double sum = 0;
        for(int i = k; i < n - k; i++) {
            sum += grades[i];
        }

        double avg = sum / (n - k * 2);
        return String.format("%.2f", avg);
    }
}
