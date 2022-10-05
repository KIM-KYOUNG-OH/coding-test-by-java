package programmers.level3;

public class BestSet {
    public int[] solution(int n, int s) {
        if(n > s) return new int[]{-1};

        int[] answer = new int[n];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = s / n;
        }

        for(int i = answer.length - 1; i >= answer.length - (s % n); i--) {
            answer[i]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        BestSet s = new BestSet();
        s.solution(2, 9);
    }
}
