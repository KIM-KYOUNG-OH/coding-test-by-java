package programmers.greedy;

import java.util.Arrays;

/**
 * 1차 : solution 참고
 * 2차 : 통과, 근데 다음에 풀 때도 그리드 알고리즘을 생각해낼 수 있을지 미지수
 */
public class SpeedCamera {
    public int solution(int[][] routes) {
        // 진입시간 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int answer = 1;
        int cameraPos = routes[0][1];
        for (int i = 0; i < routes.length - 1; i++) {
            if(cameraPos < routes[i + 1][0]) {
                answer++;
                cameraPos = routes[i + 1][1];
            }
        }

        return answer;
    }
}
