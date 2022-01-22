package programmers.level3;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: 통과
 */
public class ChuseokTraffic {
    public int solution(String[] lines) {
        int answer = 0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        getTimes(lines, startTimes, endTimes);

        for(int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int startOfSection = startTimes[i];
            int endOfSection = startOfSection + 999;

            for(int j = 0; j < lines.length; j++) {
                if(startOfSection <= startTimes[j] && startTimes[j] <= endOfSection) cnt++;
                else if(startOfSection <= endTimes[j] && endTimes[j] <= endOfSection) cnt++;
                else if(startTimes[j] <= startOfSection && endOfSection <= endTimes[j]) cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        for(int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int startOfSection = endTimes[i];
            int endOfSection = startOfSection + 999;

            for(int j = 0; j < lines.length; j++) {
                if(startOfSection <= startTimes[j] && startTimes[j] <= endOfSection) cnt++;
                else if(startOfSection <= endTimes[j] && endTimes[j] <= endOfSection) cnt++;
                else if(startTimes[j] <= startOfSection && endOfSection <= endTimes[j]) cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    private void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for(int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            String[] responseTime = log[1].split(":");
            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = 0;
            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);
            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
