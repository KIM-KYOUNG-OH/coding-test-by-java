package programmers.greedy;

import java.util.*;

public class MakeBigNumber {
    public String solution(String number, int k) {
        StringBuffer answer = new StringBuffer();
        int index = 0;
        int max = 0;
        for(int i = 0; i < number.length() - k; i++) {
            max = 0;
            for(int j = index; j < i + k + 1; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

}
