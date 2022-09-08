package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> wordsDivision = new HashMap<>();
        List<List<String>> words = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] s;
            if(!input.contains(" ")) {
                s = new String[]{input};
            } else {
                s = input.split(" ");
            }
            List<String> temp = Arrays.asList(s);
            for (String ss : temp) {
                wordsDivision.put(ss, i);
            }
            words.add(temp);
        }

//        System.out.println("wordsDivision = ");
//        for (String s : wordsDivision.keySet()) {
//            System.out.println(s + " = " + wordsDivision.get(s));
//        }

//        int i = 0;
//        for (List<String> word : words) {
//            System.out.println("i = " + i++);
//            for (String s : word) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }

        String input = br.readLine();
        String[] s;
        if(!input.contains(" ")) {
            s = new String[]{input};
        } else {
            s = input.split(" ");
        }

        int[] pointers = new int[n];
        for (String cur : s) {
//            System.out.println("cur = " + cur);
            if(!wordsDivision.containsKey(cur)) {
                System.out.println("Impossible");
                return;
            }

            Integer division = wordsDivision.get(cur);
//            System.out.println("division = " + division);
//            System.out.println("pointers[division] = " + pointers[division]);
            if(words.get(division).size() <= pointers[division]) {
                System.out.println("Impossible");
                return;
            }

            String candidate = words.get(division).get(pointers[division]++);
            if(!candidate.equals(cur)) {
                System.out.println("Impossible");
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            if(words.get(i).size() != pointers[i]) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");

        br.close();
    }
}
