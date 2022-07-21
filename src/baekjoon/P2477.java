package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> callCnt = new HashMap<>();
        List<Order> orders = new ArrayList<>();

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < 6; i++) {
            String[] s = br.readLine().split(" ");
            int direction = Integer.parseInt(s[0]);
            int distance = Integer.parseInt(s[1]);
            orders.add(new Order(direction, distance));
            callCnt.put(direction, callCnt.getOrDefault(direction, 0) + 1);
        }

        int directionOfMaxX = -1;
        int directionOfMaxY = -1;
        for (Integer key : callCnt.keySet()) {
            if(callCnt.get(key) == 1) {
                if(key == 1 || key == 2) {
                    directionOfMaxX = key;
                } else {
                    directionOfMaxY = key;
                }
            }
        }

        orders.addAll(orders);
        int plusX = 0;
        int plusY = 0;
        int minusX = 0;
        int minusY = 0;
        for (int i = 0; i < 6; i++) {
            Order cur = orders.get(i);
            if(cur.direction == directionOfMaxX) {
                plusX = cur.distance;
                Order next = orders.get(i + 1);
                if(next.direction == directionOfMaxY) {
                    minusX = orders.get(i + 3).distance;
                    minusY = orders.get(i + 4).distance;
                }
            } else if(cur.direction == directionOfMaxY) {
                plusY = cur.distance;
                Order next = orders.get(i + 1);
                if(next.direction == directionOfMaxX) {
                    minusY = orders.get(i + 3).distance;
                    minusX = orders.get(i + 4).distance;
                }
            }
        }

        System.out.println((plusX * plusY - minusX * minusY) * k);

        br.close();
    }

    private static class Order{
        int direction;
        int distance;

        public Order(int direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }
}
