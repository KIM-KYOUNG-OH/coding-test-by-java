package programmers.level2;

public class MatchSchedule {
    public int solution(int n, int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int round = 0;
        while(true) {
            round++;
            if(a % 2 == 1 && b == a + 1) {
                break;
            }
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return round;
    }
}
