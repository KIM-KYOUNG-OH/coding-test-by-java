package baekjoon;

import java.io.*;
import java.util.Arrays;

public class P3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        for(int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        Arrays.sort(numbers);

        int answer = 0;
        int left = 0;
        int right = n - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == x) {
                answer++;
                left++;
                right--;
            }
            else if(sum > x) {
                right--;
            } else if(sum < x) {
                left++;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
