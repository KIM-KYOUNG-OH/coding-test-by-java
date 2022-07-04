package dongbinNa;

import java.io.*;
import java.util.Arrays;

public class AdventurerOfGuild {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int groupCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count++;
            if(count >= i) {
                count = 0;
                groupCount++;
            }
        }

        bw.write(String.valueOf(groupCount));

        br.close();
        bw.close();
    }
}
