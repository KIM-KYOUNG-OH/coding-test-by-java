package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P11559 {
    static char[][] matrix;
    static List<Coordinate> toDelete;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        matrix = new char[12][6];
        for(int i = 0; i < 12; i++) {
            String s = br.readLine();
            for(int j = 0; j < 6; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        while(true) {
            toDelete = new ArrayList<>();
            predicatePuyoToDelete();

            if(toDelete.size() == 0) {
                break;
            }

            answer++;

            delete();

            drop();
        }

        System.out.println(answer);
    }

    private static void drop() {
        for(int c = 0; c < 6; c++) {
            int dropCount = 0;
            for(int r = 11; r >= 0; r--) {
                if(matrix[r][c] == '.') dropCount++;
                else {
                    if(dropCount == 0) continue;
                    matrix[r + dropCount][c] = matrix[r][c];
                    matrix[r][c] = '.';
                }
            }
        }
    }

    private static void delete() {
        for (Coordinate coordinate : toDelete) {
            matrix[coordinate.y][coordinate.x] = '.';
        }
    }

    private static void predicatePuyoToDelete() {
        boolean[][] visited = new boolean[12][6];
        LinkedList<Coordinate> q = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for(int j = 0; j < 6; j++) {
                if(matrix[i][j] == '.') continue;

                List<Coordinate> temp = new ArrayList<>();
                temp.add(new Coordinate(i, j));
                visited[i][j] = true;
                int count = 1;
                char color = matrix[i][j];
                q.add(new Coordinate(i, j));
                while(!q.isEmpty()) {
                    Coordinate cur = q.poll();
                    for(int k = 0; k < 4; k++) {
                        int ny = cur.y + dy[k];
                        int nx = cur.x + dx[k];
                        if(0 <= ny && ny < 12 && 0 <= nx && nx < 6) {
                            if(!visited[ny][nx] && matrix[ny][nx] == color) {
                                count++;
                                q.add(new Coordinate(ny, nx));
                                visited[ny][nx] = true;
                                temp.add(new Coordinate(ny, nx));
                            }
                        }
                    }
                }

                if(count >= 4) {
                    toDelete.addAll(temp);
                }
            }
        }
    }

    private static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Puyo {
        int y;
        int x;
        char color;

        public Puyo(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }
}
