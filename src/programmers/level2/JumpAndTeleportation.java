package programmers.level2;

public class JumpAndTeleportation {
    public int solution(int n) {
        int jump = 0;

        while(n != 0) {
            if(n % 2 == 0) {  // 짝수
                n /= 2;
            } else {  // 홀수
                jump++;
                n--;
            }
        }

        return jump;
    }
}
