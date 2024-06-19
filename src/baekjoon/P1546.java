package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Double> list = Arrays.stream(br.readLine().trim().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        double maxVal = Collections.max(list);
        double total = list.stream().mapToDouble(num -> num / maxVal * 100).sum();

        double result = total / n;
        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
    }
}
