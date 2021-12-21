package programmers;

import java.util.Stack;

public class ClawCraneGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int move: moves) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][move - 1] != 0) {
                    if(stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }

                    if(stack.peek() == board[j][move - 1]) {
                        stack.pop();
                        answer += 2;
                    }else {
                        stack.push(board[j][move - 1]);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
