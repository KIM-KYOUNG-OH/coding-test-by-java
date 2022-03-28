package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DifferentBitsBelowTwo {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {  // 짝수
                answer[i] = numbers[i] + 1;
            } else {  // 홀수
                String binaryString = Long.toBinaryString(numbers[i]);

                int lastZeroIndex = binaryString.lastIndexOf('0');
                int firstOneIndex = binaryString.indexOf('1', lastZeroIndex);
                if(lastZeroIndex == -1) {  // 전부 1일 때
                    numbers[i] += 1;
                    String temp = Long.toBinaryString(numbers[i]);
                    binaryString = temp.substring(0, 2) + temp.substring(2).replace('0', '1');
                } else {
                    binaryString = binaryString.substring(0, lastZeroIndex) + "1"
                            + binaryString.substring(lastZeroIndex + 1, firstOneIndex) + "0"
                            + binaryString.substring(firstOneIndex + 1);
                }

                answer[i] = Long.parseLong(binaryString, 2);
            }
        }

        return answer;
    }
}
