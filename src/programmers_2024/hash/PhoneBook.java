package programmers_2024.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public boolean solution(String[] phone_book) {

        Map<String, Boolean> map = new HashMap<>();

        for (String num : phone_book) {
            map.put(num, true);
        }

        for (String s : phone_book) {
            for (int j = 1; j < s.length(); j++) {
                String current = s.substring(0, j);
                if (map.containsKey(current)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.solution(new String[]{"123", "456", "789"});
    }
}
