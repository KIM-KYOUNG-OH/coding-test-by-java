package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class P10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i]);
            list.add(num);
        }

        bw.write(Collections.min(list) + " " + Collections.max(list));

        bw.flush();
        br.close();
    }
}
