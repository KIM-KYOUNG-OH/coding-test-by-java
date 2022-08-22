package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Gear[] gears = new Gear[t + 1];
        for(int i = 1; i <= t; i++) {
            String s = br.readLine();
            gears[i] = new Gear(s);
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int idx = Integer.parseInt(s[0]);
            int direction = Integer.parseInt(s[1]);

            int[] operations = new int[t + 1];
            operations[idx] = direction;
            // 오른쪽
            for(int j = idx + 1; j <= t; j++) {
                Gear prev = gears[j - 1];
                Gear cur = gears[j];
                if(prev.getRight() != cur.getLeft()) {
                    operations[j] = operations[j - 1] * (-1);
                } else {
                    break;
                }
            }

            // 왼쪽
            for(int j = idx - 1; j >= 1; j--) {
                Gear prev = gears[j + 1];
                Gear cur = gears[j];
                if(prev.getLeft() != cur.getRight()) {
                    operations[j] = operations[j + 1] * (-1);
                } else {
                    break;
                }
            }

            // spin
            for (int j = 1; j <= t; j++) {
                int operation = operations[j];
                Gear cur = gears[j];
                if(operation == 1) {
                    cur.rotateRight();
                } else if(operation == -1) {
                    cur.rotateLeft();
                }
            }

        }

        int answer = 0;
        for (int i = 1; i <= t; i++) {
            Gear cur = gears[i];
            if(cur.sawTooth.charAt(0) == '1') answer++;
        }

        System.out.println(answer);

        br.close();
    }

    private static class Gear {
        String sawTooth;

        public Gear(String sawTooth) {
            this.sawTooth = sawTooth;
        }

        public char getRight() {
            return sawTooth.charAt(2);
        }

        public char getLeft() {
            return sawTooth.charAt(6);
        }

        public void rotateRight() {
            sawTooth = sawTooth.charAt(7) + sawTooth.substring(0, 7);
        }

        public void rotateLeft() {
            sawTooth = sawTooth.substring(1) + sawTooth.charAt(0);
        }
    }
}
