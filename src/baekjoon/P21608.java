package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P21608 {
    static int[][] like;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nn = (int) Math.pow(n, 2);
        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, -1, 0, 1};

        like = new int[nn + 1][4];
        int[] order = new int[nn];
        for (int i = 1; i <= nn; i++) {
            String[] s = br.readLine().split(" ");
            order[i - 1] = Integer.parseInt(s[0]);
            for(int j = 1; j <= 4 ; j++) {
                like[Integer.parseInt(s[0])][j - 1] = Integer.parseInt(s[j]);
            }
        }

        int[][] matrix = new int[n + 1][n + 1];
        for(int p = 0; p < order.length; p++) {
            int student = order[p];
            List<Coordinate> maxConnectedCoordinates = new ArrayList<>();
            int maxConnectedCount = 0;

            // 1. 좋아하는 학생 수가 가장 많은 것들 뽑기
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(matrix[i][j] != 0) continue;
                    int count = 0;
                    int connectedEmptyCount = 0;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 < ny && ny <= n && 0 < nx && nx <= n) {
                            if(matrix[ny][nx] == 0) {
                                connectedEmptyCount++;
                            } else if(contains(like[student], matrix[ny][nx])) {
                                count++;
                            }
                        }
                    }

                    if(count > maxConnectedCount) {
                        maxConnectedCount = count;
                        maxConnectedCoordinates = new ArrayList<>();
                        maxConnectedCoordinates.add(new Coordinate(i, j, connectedEmptyCount));
                    } else if(count == maxConnectedCount) {
                        maxConnectedCoordinates.add(new Coordinate(i, j, connectedEmptyCount));
                    }
                }
            }

            // 2. 인접한 비어있는 칸이 제일 많은 것들 , y, x 정렬
            maxConnectedCoordinates.sort(Comparator.comparing(Coordinate::getConnectedEmpty).reversed()
                    .thenComparing(Coordinate::getY)
                    .thenComparing(Coordinate::getX));

            Coordinate coordinate = maxConnectedCoordinates.get(0);
            matrix[coordinate.y][coordinate.x] = student;
        }

        // 점수 계산
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int count = 0;
                int[] likes = like[matrix[i][j]];
                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(0 < ny && ny <= n && 0 < nx && nx <= n) {
                        if(contains(likes, matrix[ny][nx])) count++;
                    }
                }

                switch (count) {
                    case 0:
                        break;

                    case 1:
                        answer += 1;
                        break;

                    case 2:
                        answer += 10;
                        break;

                    case 3:
                        answer += 100;
                        break;

                    case 4:
                        answer += 1000;
                        break;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static boolean contains(int[] arr, int student) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == student) return true;
        }
        return false;
    }

    private static class Coordinate {
        int y;
        int x;
        int connectedEmpty;

        public Coordinate(int y, int x, int connectedEmpty) {
            this.y = y;
            this.x = x;
            this.connectedEmpty = connectedEmpty;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getConnectedEmpty() {
            return connectedEmpty;
        }
    }
}
