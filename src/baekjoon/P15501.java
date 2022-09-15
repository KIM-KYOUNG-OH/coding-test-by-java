package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int idx2 = 0;
        for(int i = 0; i < n; i++) {
            if(arr2[i] == arr1[0]) {
                idx2 = i;
                break;
            }
        }

        boolean isPossible1 = true;
        for(int i = 0; i < n; i++) {
            int temp = (idx2 + i) % n;
            if(arr1[i] != arr2[temp]) {
                isPossible1 = false;
                break;
            }
        }

        boolean isPossible2 = true;
        for(int i = 0; i < n; i++) {
            int temp = (idx2 + n - i) % n;
            if(arr1[i] != arr2[temp]) {
                isPossible2 = false;
                break;
            }
        }

        if(isPossible1 || isPossible2) {
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }

        br.close();
    }
}
