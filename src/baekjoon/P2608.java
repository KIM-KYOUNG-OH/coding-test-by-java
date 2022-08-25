package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P2608 {
    static Map<Character, Integer> charMap;
    static Map<String, Integer> stringMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        stringMap = new HashMap<>();
        stringMap.put("IV", 4);
        stringMap.put("IX", 9);
        stringMap.put("XL", 40);
        stringMap.put("XC", 90);
        stringMap.put("CD", 400);
        stringMap.put("CM", 900);

        int num1 = parseToInteger(br.readLine());
        int num2 = parseToInteger(br.readLine());

        int sum = num1 + num2;
        String str = parseToLoman(sum);

        System.out.println(sum);
        System.out.println(str);

        br.close();
    }

    private static String parseToLoman(int num) {
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        sortedMap.put(1000, "M");
        sortedMap.put(900, "CM");
        sortedMap.put(500, "D");
        sortedMap.put(400, "CD");
        sortedMap.put(100, "C");
        sortedMap.put(90, "XC");
        sortedMap.put(50, "L");
        sortedMap.put(40, "XL");
        sortedMap.put(10, "X");
        sortedMap.put(9, "IX");
        sortedMap.put(5, "V");
        sortedMap.put(4, "IV");
        sortedMap.put(1, "I");

        Map<String, Integer> cntLimit = new HashMap<>();
        cntLimit.put("M", 3);
        cntLimit.put("C", 3);
        cntLimit.put("X", 3);
        cntLimit.put("I", 3);
        cntLimit.put("V", 1);
        cntLimit.put("L", 1);
        cntLimit.put("D", 1);
        cntLimit.put("IV", 1);
        cntLimit.put("IX", 1);
        cntLimit.put("XL", 1);
        cntLimit.put("XC", 1);
        cntLimit.put("CD", 1);
        cntLimit.put("CM", 1);

        Map<String, String> cantAppear = new HashMap<>();
        cantAppear.put("IV", "IX");
        cantAppear.put("IX", "IV");
        cantAppear.put("XL", "XC");
        cantAppear.put("XC", "XL");
        cantAppear.put("CD", "CM");
        cantAppear.put("CM", "CD");

        StringBuilder sb = new StringBuilder();

        for (Integer value : sortedMap.keySet()) {
            while(num / value != 0) {
                String word = sortedMap.get(value);
                Integer limit = cntLimit.get(word);
                if(limit == 0) break;
                num -= value;
                if(word.length() > 1) {
                    cntLimit.put(cantAppear.get(word), 0);
                }
                cntLimit.put(word, limit - 1);
                sb.append(word);
            }

            if(num == 0) break;
        }

        return sb.toString();
    }

    private static int parseToInteger(String s) {
        int result = 0;
        for (String key : stringMap.keySet()) {
            if(s.contains(key)) {
                result += stringMap.get(key);
                s = s.replace(key, "");
            }
        }

        for (char c : s.toCharArray()) {
            result += charMap.get(c);
        }

        return result;
    }
}
