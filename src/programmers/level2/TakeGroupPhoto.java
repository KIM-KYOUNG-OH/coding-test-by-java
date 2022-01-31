package programmers.level2;

/**
 * 1차: solution 참고
 * 2차: 통과
 */
public class TakeGroupPhoto {
//    char[] friends;
//    boolean[] visited;
//    int answer;
//
//    public int solution(int n, String[] data) {
//        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
//        visited = new boolean[8];
//        answer = 0;
//
//        dfs(n, data, "");
//
//        return answer;
//    }
//
//    private void dfs(int n, String[] data, String people) {
//        if(people.length() == 8) {
//            if(isPossible(n ,data, people)) {
//                answer++;
//            }
//            return;
//        }
//
//        for(int i = 0; i < 8; i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                dfs(n, data, people + friends[i]);
//                visited[i] = false;
//            }
//        }
//
//        return;
//    }
//
//    private boolean isPossible(int n, String[] data, String people) {
//        for(int i = 0; i < n; i++) {
//            int fromPosition = people.indexOf(data[i].charAt(0));
//            int toPosition = people.indexOf(data[i].charAt(2));
//            char op = data[i].charAt(3);
//            int distance = data[i].charAt(4) - '0';
//            if (op == '=') {
//                if(!(Math.abs(fromPosition - toPosition) - 1 == distance)) return false;
//            }else if(op == '<') {
//                if(!(Math.abs(fromPosition - toPosition) - 1 < distance)) return false;
//            }else if(op == '>') {
//                if(!(Math.abs(fromPosition - toPosition) - 1 > distance)) return false;
//            }
//        }
//
//        return true;
//    }
    char[] friends;
    boolean[] visited;
    int answer;

    public int solution(int n, String[] data) {
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        answer = 0;

        dfs(n, data, "");

        return answer;
    }

    private void dfs(int n, String[] data, String people) {
        if(people.length() == 8) {
            if(isPossible(data, people)) {
                answer++;
            }
            return;
        }

        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, data, people + friends[i]);
                visited[i] = false;
            }
        }

        return;
    }

    private boolean isPossible(String[] data, String people) {
        for(String condition: data) {
            char from = condition.charAt(0);
            int fromPos = people.indexOf(from);
            char to = condition.charAt(2);
            int toPos = people.indexOf(to);
            char oper = condition.charAt(3);
            int betweenCnt = condition.charAt(4) - '0';
            if(oper == '=') {
                if((Math.abs(fromPos - toPos) - 1) != betweenCnt) return false;
            }else if(oper == '<') {
                if((Math.abs(fromPos - toPos) - 1) >= betweenCnt) return false;
            }else if(oper == '>') {
                if((Math.abs(fromPos - toPos) - 1) <= betweenCnt) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TakeGroupPhoto s = new TakeGroupPhoto();
        System.out.println(s.solution(	2, new String[]{"N~F=0", "R~T>2"}));
    }
}
