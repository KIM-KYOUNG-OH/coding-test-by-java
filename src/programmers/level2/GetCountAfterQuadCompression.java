package programmers.level2;

public class GetCountAfterQuadCompression {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];

        dp(0, 0, arr.length, arr);

        for (int i : answer) {
            System.out.print(i + " ");
        }
        return answer;
    }

    private void dp(int startY, int startX, int size, int[][] arr) {
        if(isPossible(startY, startX, size, arr)) {
            answer[arr[startY][startX]] += 1;
            return;
        }

        dp(startY, startX, size / 2, arr);
        dp(startY + size / 2, startX, size / 2, arr);
        dp(startY, startX + size / 2, size / 2, arr);
        dp(startY + size / 2, startX + size / 2, size / 2, arr);
    }

    private boolean isPossible(int startY, int startX, int size, int[][] arr) {
        for(int i = startY; i < startY + size; i++) {
            for(int j = startX; j < startX + size; j++) {
                if(arr[startY][startX] != arr[i][j]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        GetCountAfterQuadCompression s = new GetCountAfterQuadCompression();
        s.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }
}
