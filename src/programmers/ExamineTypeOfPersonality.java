package programmers;

import java.util.HashMap;
import java.util.Map;

public class ExamineTypeOfPersonality {
    public String solution(String[] survey, int[] choices) {
        int n = survey.length;
        Map<Character, Integer> alps = new HashMap<>();
        alps.put('R', 0);
        alps.put('T', 0);
        alps.put('C', 0);
        alps.put('F', 0);
        alps.put('J', 0);
        alps.put('M', 0);
        alps.put('A', 0);
        alps.put('N', 0);
        int[] grade = new int[]{0, 3, 2, 1, 0, 1, 2, 3};

        for(int i = 0; i < n; i++) {
            String cur = survey[i];
            int choice = choices[i];
            if(choice == 4) {
                continue;
            } else if(choice < 4) {
                char leftAlp = cur.charAt(0);
                int score = alps.get(leftAlp);
                alps.put(leftAlp, score + grade[choice]);
            } else {
                char rightAlp = cur.charAt(1);
                int score = alps.get(rightAlp);
                alps.put(rightAlp, score + grade[choice]);
            }
        }

        String answer = "";
        // RT
        int R = alps.get('R');
        int T = alps.get('T');
        if(R >= T) answer += 'R';
        else answer += 'T';

        // CF
        int C = alps.get('C');
        int F = alps.get('F');
        if(C >= F) answer += 'C';
        else answer += 'F';

        // JM
        int J = alps.get('J');
        int M = alps.get('M');
        if(J >= M) answer += 'J';
        else answer += 'M';

        // AN
        int A = alps.get('A');
        int N = alps.get('N');
        if(A >= N) answer += 'A';
        else answer += 'N';

        return answer;
    }

    public static void main(String[] args) {
        ExamineTypeOfPersonality s = new ExamineTypeOfPersonality();
        String solution = s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println(solution);
    }
}
