package dongbinNa.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LawsOfLargeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());

        int first = list.get(0);
        int second = list.get(1);

        int curM = m;
        int curK = k;
        int answer = 0;
        while (curM > 0) {
            if (curK > 0) {
                curK -= 1;
                answer += first;
            } else {
                curK += k;
                answer += second;
            }

            curM -= 1;
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}

//5 8 3
//2 4 5 4 6