package programmers.dfsAndBfs;

/**
 * 1차: solution 참고
 * 2차: 통과
 */
public class TargetNumber {
    private static int count = 0;

    private void dfs(int[] numbers, int target, int depth, int result) {
        if(depth == numbers.length) {
            if(target == result) {
                count++;
            }
            return;
        }

        int add = result + numbers[depth];
        int sub = result - numbers[depth];

        dfs(numbers, target, depth + 1, add);
        dfs(numbers, target, depth + 1, sub);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return count;
    }
}
