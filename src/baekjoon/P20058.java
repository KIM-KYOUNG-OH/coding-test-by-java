package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class P20058 {
    static int n;
    static int q;
    static int[][] matrix;
    static int[] orders;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        q = Integer.parseInt(s[1]);

        int len = (int) Math.pow(2, n);
        matrix = new int[len][len];
        for(int i = 0; i < len; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < len; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        String ss = br.readLine();
        if(q == 1) {
            orders = new int[]{Integer.parseInt(ss)};
        } else {
            orders = Arrays.stream(ss.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < orders.length; i++) {
            int order = orders[i];

            rotate(order);

            melting(order);

//            System.out.println("matrix : ");
//            for(int p = 0; p < len; p++) {
//                for(int q = 0; q < len; q++) {
//                    System.out.print(matrix[p][q] + " ");
//                }
//                System.out.println();
//            }
        }

        int sum = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                sum += matrix[i][j];
            }
        }

        int maxArea = getMaxArea();

        System.out.println(sum);
        System.out.println(maxArea);

        br.close();
    }

    private static void melting(int order) {
        int len = (int) Math.pow(2, n);
        int[][] minus = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int cnt = 0;
                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(0 <= ny && ny < len && 0 <= nx && nx < len) {
                        if(matrix[ny][nx] != 0) cnt++;
                    }
                }
                if(cnt < 3) minus[i][j] = 1;
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                matrix[i][j] -= minus[i][j];
                if(matrix[i][j] < 0) matrix[i][j] = 0;
            }
        }
    }

    private static void rotate(int order) {
        int len = (int) Math.pow(2, n);
        int interval = (int) Math.pow(2, order);
        for(int k = 0; k < (int) Math.pow(len / interval, 2); k++) {
            int y = k / (len / interval) * interval;
            int x = (k % (len / interval)) * interval;
            int[][] temp = new int[interval][interval];
            for(int i = y; i < y + interval; i++) {
                for(int j = x; j < x + interval; j++) {
                    temp[j - x][interval - 1 - (i - y)] = matrix[i][j];
                }
            }

            for(int i = 0; i < interval; i++) {
                for(int j = 0; j < interval; j++) {
                    matrix[y + i][x + j] = temp[i][j];
                }
            }
        }
    }

    private static int getMaxArea() {
        int len = (int) Math.pow(2, n);
        int maxArea = 0;
        boolean[][] visited = new boolean[len][len];
        LinkedList<Coordinate> q = new LinkedList<>();

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(visited[i][j]) continue;

                if(matrix[i][j] == 0) continue;

                q.add(new Coordinate(i, j));
                visited[i][j] = true;
                int cnt = 1;
                while(!q.isEmpty()) {
                    Coordinate cur = q.poll();
                    for(int k = 0; k < 4; k++) {
                        int ny = cur.y + dy[k];
                        int nx = cur.x + dx[k];
                        if(0 <= ny && ny < len && 0 <= nx && nx < len) {
                            if(!visited[ny][nx] && matrix[ny][nx] != 0) {
                                visited[ny][nx] = true;
                                cnt++;
                                q.add(new Coordinate(ny, nx));
                            }
                        }
                    }
                }

                maxArea = Math.max(maxArea, cnt);
            }
        }

        return maxArea;
    }

    private static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
