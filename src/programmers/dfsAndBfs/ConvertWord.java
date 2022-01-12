package programmers.dfsAndBfs;

import java.util.*;

/**
 * 1차: 통과, 사용자 정의 클래스 선언, visited 선언
 */
public class ConvertWord {
    private class Node {
        String str;
        int convertingCnt;

        public Node(String str, int convertingCnt) {
            this.str = str;
            this.convertingCnt = convertingCnt;
        }
    }

    private int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        Node node = new Node(begin, 0);
        q.add(node);
        while(!q.isEmpty()) {
            Node cur = q.poll();
            String str = cur.str;
            int convertingCnt = cur.convertingCnt;

            if(convertingCnt > words.length) break;
            if(str.equals(target)) return convertingCnt;

            for (String word : words) {
                if(isPossibleToConvert(str, word)) {
                    q.add(new Node(word, convertingCnt + 1));
                }
            }
        }
        return 0;
    }

    private boolean isPossibleToConvert(String from, String to) {
        int diffCnt = 0;
        for(int i = 0; i < from.length(); i++) {
            char fromC = from.charAt(i);
            char toC = to.charAt(i);
            if(fromC != toC) diffCnt++;
            if(diffCnt > 1) return false;
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
}
