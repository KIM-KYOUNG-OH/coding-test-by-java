package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16113 {
    static int n;
    static int r;
    static int c;
    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        r = 5;
        c = n / r;
        matrix = new char[r][c];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            matrix[i / c][i % c] = ch;
        }

        StringBuilder sb;
        int i = 0;
        StringBuilder answer = new StringBuilder();
        while(i < c) {
            sb = new StringBuilder();
            for(int j = 0; j < r; j++) {
                sb.append(matrix[j][i]);
            }

            String first = sb.toString();
            if(first.equals(".....")) i++;
            else if(first.equals("#####")) {
                if(i == c - 1) {
                    answer.append("1");
                    break;
                }

                sb.delete(0, 5);
                for(int j = 0; j < r; j++) {
                    sb.append(matrix[j][i + 1]);
                }

                String second = sb.toString();
                if(second.equals(".....")) {
                    answer.append("1");
                    i++;
                } else if(second.equals("#...#")) {
                    answer.append("0");
                    i += 3;
                } else if(second.equals("#.#.#")) {
                    sb.delete(0, 5);
                    for(int j = 0; j < r; j++) {
                        sb.append(matrix[j][i + 2]);
                    }

                    String third = sb.toString();
                    if(third.equals("#.###")) {
                        answer.append("6");
                        i += 3;
                    } else if(third.equals("#####")) {
                        answer.append("8");
                        i += 3;
                    }
                }
            } else if(first.equals("#.###")) {
                answer.append("2");
                i += 3;
            } else if(first.equals("#.#.#")) {
                answer.append("3");
                i += 3;
            } else if(first.equals("###..")) {
                answer.append("4");
                i += 3;
            } else if(first.equals("#....")) {
                answer.append("7");
                i += 3;
            } else if(first.equals("###.#")) {
                sb.delete(0, 5);
                for(int j = 0; j < r; j++) {
                    sb.append(matrix[j][i + 2]);
                }

                String third = sb.toString();
                if(third.equals("#.###")) {
                    answer.append("5");
                    i += 3;
                } else if(third.equals("#####")) {
                    answer.append("9");
                    i += 3;
                }
            }
        }

        System.out.println(answer.toString());

        br.close();
    }
}
