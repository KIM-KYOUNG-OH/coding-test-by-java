package baekjoon;

import java.io.*;

public class P10997 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        if(n == 1) {
            bw.write("*");

            br.close();
            bw.close();
            return;
        }

        // 아래 피라미드
        char[][] underPyramid = getPyramid();

        // 위 피라미드
        char[][] upperPyramid = getPyramid();

        // 추가 별 찍기
        plusExtraStars(upperPyramid, upperPyramid.length);

        // 추가 별 지우기
        minusExtraStars(upperPyramid, upperPyramid.length);

        // 뒤집기
        upperPyramid = reverse(upperPyramid, upperPyramid.length);

        // 아래 위 피라미드 합치기
        int l = underPyramid.length;
        int ll = l * 2 + 3;
        int mid = ll / 2;
        char[][] matrix = new char[ll][l];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                matrix[i][j] = upperPyramid[i][j];
                matrix[i + l + 3][j] = underPyramid[i][j];
            }
        }

        // 중간 부분 3라인 채우기
        for(int i = mid - 1; i < mid + 1; i++) {
            for (int j = 0; j < l; j++) {
                if(i == mid && j % 2 == 0) {
                    matrix[i][j] = '*';
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        // 출력
        for(int i = 0; i < ll; i++) {
            if(i % 2 == 1) continue;
            for(int j = 0; j < l; j++) {
                bw.write(matrix[i][j]);
                if(i == 2) break;
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static char[][] reverse(char[][] upperPyramid, int l) {
        char[][] result = new char[l][l];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                result[l - 1 - i][j] = upperPyramid[i][j];
            }
        }

        return result;
    }

    private static void minusExtraStars(char[][] upperPyramid, int l) {
        int mid = l / 2;
        for(int i = 2; i < l; i = i + 4) {
            upperPyramid[i][mid + ((i + 4) / 4) * 2] = ' ';
        }
    }

    private static void plusExtraStars(char[][] upperPyramid, int l) {
        int mid = l / 2;
        for(int i = 0; i < l - 1; i = i + 4) {
            upperPyramid[i][mid + (i / 4) * 2 + 1] = '*';
        }
    }

    private static char[][] getPyramid() {
        // 초기화
        int l = 4 * (n - 1) + 1;
        char[][] pyramid = new char[l][l];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                if(i % 2 == 0 && j % 2 == 0) pyramid[i][j] = '*';
                else pyramid[i][j] = ' ';
            }
        }

        // 별 찍기
        for(int i = 0; i < l; i = i + 4) {
            for(int j = (l - 1 - i) / 2; j < l - (l - 1 - i) / 2; j++) {
                pyramid[i][j] = '*';
            }
        }

        // 별 지우기
        for(int i = 2; i < l; i = i + 4) {
            for(int j = (l - 1 - i) / 2; j < l - (l - 1 - i) / 2; j++) {
                pyramid[i][j] = ' ';
            }
        }

        return pyramid;
    }
}
