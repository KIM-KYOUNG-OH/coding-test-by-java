package programmers.level2;

public class NRadixGame {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(sb.length() < t * m) {
            String pNum = parseToNRadix(n, num);
            sb.append(pNum);
            num++;
        }

        String s = sb.toString();
        sb = new StringBuilder();
        for(int i = p - 1; i < s.length() && t > 0; i = i + m) {
            sb.append(s.charAt(i));
            t--;
        }

        return sb.toString();
    }

    private String parseToNRadix(int n, int num) {
        if(num == 0) return "0";

        StringBuilder s = new StringBuilder();
        while(num > 0) {
            int remainder = num % n;
            String temp = String.valueOf(remainder);
            if(remainder >= 10) {
                temp = String.valueOf((char) (remainder - 10 + 65));
            }
            s.insert(0, temp);
            num /= n;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        NRadixGame s = new NRadixGame();
        s.solution(16, 16, 2, 2);
    }
}
