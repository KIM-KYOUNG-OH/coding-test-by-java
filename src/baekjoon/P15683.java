package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15683 {
    static int n;
    static int m;
    static int[][] matrix;
    static List<Camera> cameras;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        matrix = new int[n][m];
        cameras = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
                if(0 < matrix[i][j] && matrix[i][j] < 6) {
                    cameras.add(new Camera(i, j, matrix[i][j]));
                }
            }
        }

        if(cameras.size() == 0) {
            answer = getCountOfBlindSpot();
            System.out.println(answer);
            return;
        }

        answer = 64;
        recursive(0);

        System.out.println(answer);

        br.close();
    }

    private static void recursive(int index) {
        if(index >= cameras.size()) {
            int count = getCountOfBlindSpot();
            answer = Math.min(answer, count);
            return;
        }

        Camera current = cameras.get(index);
        for(int i = 0; i < 4; i++) {
            current.direction = i;
            current.watch();
            recursive(index + 1);
            current.rollback();
        }
    }

    private static int getCountOfBlindSpot() {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static class Camera {
        int y;
        int x;
        int type;
        int direction;

        public Camera(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
            this.direction = 0;
        }

        public void watch() {
            if(type == 1) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if(0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if(matrix[ny][nx] == 6) break;

                    if(matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }
            } else if(type == 2) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 2) % 4];
                    nx = nx + dx[(direction + 2) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }
            } else if(type == 3) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 1) % 4];
                    nx = nx + dx[(direction + 1) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }
            } else if(type == 4) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 1) % 4];
                    nx = nx + dx[(direction + 1) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 3) % 4];
                    nx = nx + dx[(direction + 3) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }
            } else if(type == 5) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 1) % 4];
                    nx = nx + dx[(direction + 1) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 2) % 4];
                    nx = nx + dx[(direction + 2) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 3) % 4];
                    nx = nx + dx[(direction + 3) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] -= 1;
                }
            }
        }

        public void rollback() {
            if(type == 1) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if(0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if(matrix[ny][nx] == 6) break;

                    if(matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }
            } else if(type == 2) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 2) % 4];
                    nx = nx + dx[(direction + 2) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }
            } else if(type == 3) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 1) % 4];
                    nx = nx + dx[(direction + 1) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }
            } else if(type == 4) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 1) % 4];
                    nx = nx + dx[(direction + 1) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 3) % 4];
                    nx = nx + dx[(direction + 3) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }
            } else if(type == 5) {
                int ny = y;
                int nx = x;
                while(true) {
                    ny = ny + dy[direction];
                    nx = nx + dx[direction];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 1) % 4];
                    nx = nx + dx[(direction + 1) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 2) % 4];
                    nx = nx + dx[(direction + 2) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }

                ny = y;
                nx = x;
                while(true) {
                    ny = ny + dy[(direction + 3) % 4];
                    nx = nx + dx[(direction + 3) % 4];

                    if (0 > ny || ny >= n || 0 > nx || nx >= m) break;
                    if (matrix[ny][nx] == 6) break;

                    if (matrix[ny][nx] <= 0) matrix[ny][nx] += 1;
                }
            }
        }
    }
}
