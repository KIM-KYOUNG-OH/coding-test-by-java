package programmers_2024.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Node> bridge = new LinkedList<>();
        Deque<Node> waiting = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            waiting.add(new Node(truckWeight, 0));
        }

        int answer = 0;
        int currentBridgeWeight = 0;
        while (waiting.size() > 0 || bridge.size() > 0) {
            answer++;

            // 빼기
            int currentTruckCnt = bridge.size();
            for (int i = 0; i < currentTruckCnt; i++) {
                Node node = bridge.poll();
                if (node.getMove() < bridge_length) {
                    node.setMove(node.getMove() + 1);
                    bridge.add(node);
                } else {
                    currentBridgeWeight -= node.getWeight();
                }
            }

            // 넣기
            if (waiting.size() > 0) {
                Node first = waiting.peekFirst();
                if (first.getWeight() + currentBridgeWeight <= weight && bridge.size() < bridge_length) {
                    first = waiting.pollFirst();
                    first.setMove(first.getMove() + 1);
                    bridge.add(first);
                    currentBridgeWeight += first.getWeight();
                }
            }
        }

        return answer;
    }

    private class Node {
        private int weight;
        private int move;

        public Node(int weight, int move) {
            this.weight = weight;
            this.move = move;
        }

        public int getWeight() {
            return weight;
        }

        public int getMove() {
            return move;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setMove(int move) {
            this.move = move;
        }
    }

    public static void main(String[] args) {
        Truck s = new Truck();
        s.solution(2, 10, new int[]{7, 4, 5, 6});
    }
}
