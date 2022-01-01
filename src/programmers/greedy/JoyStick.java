package programmers.greedy;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int minMoveCnt = len - 1;  // 그냥 오른쪽으로 이동

        for(int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int upDownMoveCnt = 0 ;
            if (c - 'A' < 'Z' - c + 1) {
                upDownMoveCnt = c - 'A';
            }else {
                upDownMoveCnt = 'Z' - c + 1;
            }
            answer += upDownMoveCnt;

            int nextIndex = i + 1;
            while (nextIndex < len && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            minMoveCnt = Math.min(minMoveCnt, (i * 2) + len - nextIndex);
        }

        answer += minMoveCnt;

        return answer;
    }
}
