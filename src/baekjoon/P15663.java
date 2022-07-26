package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15663 {
    static boolean[] visited;
    static int[] nums;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        visited = new boolean[n + 1];
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        map = new HashMap<>();

        recursive(new ArrayList<>(), n, m);
    }

    private static void recursive(List<Integer> list, int n, int m) {
        if(list.size() >= m) {
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < list.size(); i++) {
                if(i == list.size() - 1) {
                    temp.append(list.get(i));
                } else {
                    temp.append(list.get(i)).append(" ");
                }
            }

            if(map.get(temp.toString()) == null) {
                map.put(temp.toString(), 1);
                System.out.println(temp);
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                recursive(list, n, m);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
