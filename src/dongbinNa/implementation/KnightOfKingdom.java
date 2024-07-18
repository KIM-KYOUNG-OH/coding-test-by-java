package dongbinNa.implementation;

import java.io.*;

public class KnightOfKingdom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dy = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dx = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
        String s = br.readLine();
        int x = s.charAt(0) - 'a' + 1;
        int y = s.charAt(1) - '1' + 1;

        int answer = 0;
        for (int k = 0; k < 8; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (0 < ny && ny <= 8 && 0 < nx && nx <= 8) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
