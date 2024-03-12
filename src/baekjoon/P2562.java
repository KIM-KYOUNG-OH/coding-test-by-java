package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
            map.put(num, i);
        }

        int max = Collections.max(list);
        bw.write(max + "\n" + map.get(max));

        bw.flush();
        br.close();
    }

}
