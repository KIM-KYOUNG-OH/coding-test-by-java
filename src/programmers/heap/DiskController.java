package programmers.heap;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {  // 작업 요청 시점, 작업 소요 시간
        int answer = 0;
        int curTime = 0;  // 수행직후 시간
        int jobsIdx = 0;  // jobs 배열 인덱스
        int count = 0;  // 수행된 요청 개수

        // 작업 요청 시점 오름차순
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 작업 소요 시간순 최소 힙
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while(count < jobs.length) {
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= curTime) {
                heap.offer(jobs[jobsIdx]);
                jobsIdx++;
            }

            if(heap.isEmpty()) {
                curTime = jobs[jobsIdx][0];
            }else{
                int[] temp = heap.poll();
                answer += temp[1] + curTime - temp[0];
                curTime += temp[1];
                count++;
            }
        }

        return (int)Math.floor(answer / jobs.length);
    }
}
