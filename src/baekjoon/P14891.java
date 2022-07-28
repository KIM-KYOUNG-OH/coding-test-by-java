package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14891 {
    private static class Gear{
        int[] data = new int[8];

        public Gear(String data) {
            char[] gearArr = data.toCharArray();
            int i = 0;
            for (char num : gearArr) {
                this.data[i++] = Integer.parseInt(String.valueOf(num));
            }
        }

        public int getLeft() {
            return data[6];
        }

        public int getRight() {
            return data[2];
        }

        public void rotateClockwise() {
            int temp = data[7];
            for(int i = 6; i >= 0; i--) {
                data[i + 1] = data[i];
            }
            data[0] = temp;
        }

        public void rotateCounterClockwise() {
            int temp = data[0];
            for(int i = 1; i < 8; i++) {
                data[i - 1] = data[i];
            }
            data[7] = temp;
        }

        public void print() {
            for (int num : data) {
                System.out.print(num);
            }
            System.out.println();
        }

        public int getGrade() {
            return data[0];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Gear gear1 = new Gear(br.readLine());
        Gear gear2 = new Gear(br.readLine());
        Gear gear3 = new Gear(br.readLine());
        Gear gear4 = new Gear(br.readLine());
        Gear[] gears = new Gear[]{gear1, gear2, gear3, gear4};

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int target = Integer.parseInt(s[0]) - 1;
            int direction = Integer.parseInt(s[1]);
            
            int[] orders = new int[4];
            orders[target] = direction;
            for(int j = target + 1; j < 4; j++) {
                if(gears[j - 1].getRight() != gears[j].getLeft()) {
                    orders[j] = orders[j - 1] * -1;
                } else{
                    break;
                }
            }

            for(int j = target - 1; j >= 0; j--) {
                if(gears[j + 1].getLeft() != gears[j].getRight()) {
                    orders[j] = orders[j + 1] * -1;
                } else {
                    break;
                }
            }

            for(int j = 0; j < 4; j++) {
                if(orders[j] == 1) {
                    gears[j].rotateClockwise();
                } else if(orders[j] == -1) {
                    gears[j].rotateCounterClockwise();
                }
            }

        }

        int answer = 0;

        if(gears[0].getGrade() == 1) answer += 1;
        if(gears[1].getGrade() == 1) answer += 2;
        if(gears[2].getGrade() == 1) answer += 4;
        if(gears[3].getGrade() == 1) answer += 8;
        System.out.println(answer);
    }

}
