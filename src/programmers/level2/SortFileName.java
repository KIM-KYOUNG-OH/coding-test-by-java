package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortFileName {
    public String[] solution(String[] files) {
        List<Files> list = new ArrayList<>();
        for (String file : files) {
            StringBuilder head = new StringBuilder();
            int idx = 0;
            while(true) {
                if(file.charAt(idx) >= 48 && file.charAt(idx) <= 57) {
                    break;
                }
                head.append(file.charAt(idx++));
            }

            StringBuilder number = new StringBuilder();
            while(true) {
                if(idx >= file.length() || file.charAt(idx) < 48 || file.charAt(idx) > 57) {
                    break;
                }

                number.append(file.charAt(idx++));
            }

            String tail = file.substring(idx);

            list.add(new Files(head.toString(), number.toString(), tail));
        }

        list.sort(Comparator.comparing(Files::getHead).thenComparing(Files::getNumber));

        String[] answer = new String[list.size()];
        int idx = 0;
        for (Files file : list) {
            answer[idx++] = file.head + file.number + file.tail;
        }

        return answer;
    }

    private class Files {
        String head;
        String number;
        String tail;

        public Files(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head.toLowerCase();
        }

        public int getNumber() {
            return Integer.parseInt(number);
        }

        public String getTail() {
            return tail;
        }
    }

    public static void main(String[] args) {
        SortFileName s = new SortFileName();
        s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }
}
