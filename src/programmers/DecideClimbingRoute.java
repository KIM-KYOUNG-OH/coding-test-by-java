package programmers;

import java.util.*;

public class DecideClimbingRoute {
    static List<List<Node>> graph = new ArrayList<>();
    static Map<Integer, Boolean> summitMap = new HashMap<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            int cost = path[2];
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        for (int summit : summits) {
            summitMap.put(summit, true);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getCost).thenComparing(Node::getIdx));
        Arrays.sort(summits);

        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensities[gate] = 0;
        }

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(summitMap.containsKey(now.idx)) {
                continue;
            }

            if(intensities[now.idx] < now.cost) continue;

            for (Node next : graph.get(now.idx)) {
                int intensity = Math.max(next.cost, now.cost);
                if(intensities[next.idx] > intensity) {
                    intensities[next.idx] = intensity;
                    pq.offer(new Node(next.idx, intensity));
                }
            }
        }

        int idx = -1;
        int minIntensity = Integer.MAX_VALUE;
        for (int summit : summits) {
            if(intensities[summit] < minIntensity) {
                minIntensity = intensities[summit];
                idx = summit;
            }
        }

        return new int[]{idx, minIntensity};
    }

    private static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        public int getIdx() {
            return idx;
        }

        public int getCost() {
            return cost;
        }
    }

//    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
//        ArrayList<ArrayList<Node>> graph = createGraph(n, paths);
//        HashMap<Integer, Boolean> summitMap = createSummitMap(summits);
//        HashMap<Integer, Boolean> gateMap = createGateMap(summits);
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        Arrays.sort(summits);
//
//        int[] intensities = new int[n + 1];
//        Arrays.fill(intensities, Integer.MAX_VALUE);
//
//        for (int gate : gates) {
//            pq.offer(new Node(gate, 0));
//            intensities[gate] = 0;
//        }
//
//        while (!pq.isEmpty()) {
//            Node now = pq.poll();
//
//            System.out.println("now.index = " + now.index);
//            System.out.println("intensities = " + now.intensity);
//
//            if (summitMap.containsKey(now.index)) {
//                System.out.println("check!!");
//                continue;
//            }
//
//            if (intensities[now.index] < now.intensity) {
//                continue;
//            }
//
//            for (Node next : graph.get(now.index)) {
//                int intensity =
//                        (next.intensity == Integer.MAX_VALUE) ? now.intensity : Math.max(next.intensity, now.intensity);
//                if (intensities[next.index] > intensity) {
//                    intensities[next.index] = intensity;
//                    pq.offer(new Node(next.index, intensity));
//                }
//            }
//        }
//
//        int index = -1;
//        int minIntensity = Integer.MAX_VALUE;
//        for (int summit : summits) {
//            if (intensities[summit] < minIntensity) {
//                minIntensity = intensities[summit];
//                index = summit;
//            }
//        }
//
//        System.out.println("index = " + index);
//        System.out.println("minIntensity = " + minIntensity);
//        return new int[]{index, minIntensity};
//    }
//
//    private static HashMap<Integer, Boolean> createGateMap(int[] gates) {
//        HashMap<Integer, Boolean> gateMap = new HashMap<>();
//        for (int gate : gates) {
//            gateMap.put(gate, true);
//        }
//        return gateMap;
//    }
//
//    private static HashMap<Integer, Boolean> createSummitMap(int[] summits) {
//        HashMap<Integer, Boolean> summitMap = new HashMap<>();
//        for (int summit : summits) {
//            summitMap.put(summit, true);
//        }
//        return summitMap;
//    }
//
//    private ArrayList<ArrayList<Node>> createGraph(int n, int[][] paths) {
//        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
//        for (int i = 0; i <= n; i++) {
//            graph.add(new ArrayList<>());
//        }
//        for (int[] p : paths) {
//            graph.get(p[0]).add(new Node(p[1], p[2]));
//            graph.get(p[1]).add(new Node(p[0], p[2]));
//        }
//
//        return graph;
//    }
//
//    class Node implements Comparable<Node> {
//        int index;
//        int intensity;
//
//        public Node(int index, int intensity) {
//            this.index = index;
//            this.intensity = intensity;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            return this.intensity - o.intensity;
//        }
//    }

    public static void main(String[] args) {
        DecideClimbingRoute s = new DecideClimbingRoute();
        s.solution(7, new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}}, new int[]{1}, new int[]{2, 3, 4});
    }
}
