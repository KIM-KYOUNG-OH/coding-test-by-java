package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class P17406 {
    static int n;
    static int m;
    static int k;
    static int[][] matrix;
    static int[][] initMatrix;
    static Operation[] operations;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        answer = Integer.MAX_VALUE;
        initMatrix = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                initMatrix[i + 1][j + 1] = Integer.parseInt(ss[j]);
            }
        }

        operations = new Operation[k];
        visited = new boolean[k];
        for(int i = 0; i < k; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            operations[i] = new Operation(temp[0], temp[1], temp[2]);
        }

        recursive(0, new LinkedList<>());

        System.out.println(answer);

        br.close();
    }

    private static void recursive(int depth, LinkedList<Operation> list) {
        if(depth >= k) {
            initMatrix();
            rotate(list);
            int min = calculate();
            answer = Math.min(answer, min);
            return;
        }

        for(int i = 0; i < k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(operations[i]);
                recursive(depth + 1, list);
                list.removeLast();
                visited[i] = false;
            }
        }
    }

    private static void initMatrix() {
        matrix = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                matrix[i][j] = initMatrix[i][j];
            }
        }
    }

    private static int calculate() {
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= m; j++) {
                sum += matrix[i][j];
            }
            min = Math.min(min, sum);
        }

        return min;
    }

    private static void rotate(LinkedList<Operation> list) {
        for (Operation next : list) {
            int r = next.r;
            int c = next.c;
            int s = next.s;

            for (int i = 0; i <= s - 1; i++) {
                int startY = r - s + i;
                int startX = c - s + i;
                int endY = r + s - i;
                int endX = c + s - i;
                int len = endX - startX + 1;

                int temp = matrix[startY][endX];
                // 위
                for(int j = 0; j < len - 1; j++) {
                    matrix[startY][endX - j] = matrix[startY][endX - j - 1];
                }

                // 왼
                for(int j = 0; j < len - 1; j++) {
                    matrix[startY + j][startX] = matrix[startY + j + 1][startX];
                }

                // 아래
                for(int j = 0; j < len - 1; j++) {
                    matrix[endY][startX + j] = matrix[endY][startX + j + 1];
                }

                // 오른
                for(int j = 0; j < len - 1; j++) {
                    if(j == len - 2) {
                        matrix[endY - j][endX] = temp;
                        break;
                    }
                    matrix[endY - j][endX] = matrix[endY - j - 1][endX];
                }
            }
        }


    }

    private static class Operation {
        int r;
        int c;
        int s;

        public Operation(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
