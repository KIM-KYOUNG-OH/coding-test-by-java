package programmers.hash;

import java.util.Arrays;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0; i < phone_book.length - 1; i++) {
            String number1 = phone_book[i];
            String number2 = phone_book[i + 1];
            if(number1.startsWith(number2)) {
                return false;
            }else if(number2.startsWith(number1)) {
                return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PhoneNumberList s = new PhoneNumberList();
        System.out.println(s.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}
