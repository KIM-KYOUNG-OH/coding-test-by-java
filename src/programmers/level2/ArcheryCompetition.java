package programmers.level2;

public class ArcheryCompetition {
//    int max;
//    int[] lion;
//    int[] answer;
//
//    public int[] solution(int n, int[] info) {
//        max = 0;
//        lion = new int[11];
//        answer = new int[]{-1};
//        dfs(n, info, 0);
//
//        for (int i : answer) {
//            System.out.print(i + " ");
//        }
//        return answer;
//    }
//
//    private void dfs(int n, int[] apeach, int cnt) {
//        if (cnt == n) {
//            int apeachScore = 0;
//            int lionScore = 0;
//            for (int i = 0; i < 11; i++) {
//                if (apeach[i] != 0 || lion[i] != 0) {
//                    if (apeach[i] >= lion[i]) {
//                        apeachScore += 10 - i;
//                    } else {
//                        lionScore += 10 - i;
//                    }
//                }
//            }
//
//            if (lionScore > apeachScore) {
//                if (lionScore - apeachScore >= max) {
//                    answer = lion.clone();
//                    max = lionScore - apeachScore;
//                }
//            }
//            return;
//        }
//
//        for (int i = 0; i < 11; i++) {
//            if (lion[i] <= apeach[i]) {
//                lion[i]++;
//                dfs(n, apeach, cnt + 1);
//                lion[i]--;
//            } else {
//                break;
//            }
//        }
//    }

//    static int max;
//    static int[] answer;
//    static int[] lion;
//
//    public int[] solution(int n, int[] info) {
//        max = 0;
//        answer = new int[]{-1};
//        lion = new int[11];
//        dfs(n, info, 0);
//
//        return answer;
//    }
//
//    private void dfs(int n, int[] apeach, int cnt) {
//        if(cnt == n) {
//            int apeachScore = 0;
//            int lionScore = 0;
//            for(int i = 0; i < 11; i++) {
//                if(apeach[i] == 0 && lion[i] == 0) continue;
//
//                if(apeach[i] >= lion[i]) {
//                    apeachScore += 10 - i;
//                } else {
//                    lionScore += 10 - i;
//                }
//            }
//
//            if(apeachScore < lionScore) {
//                if(lionScore - apeachScore >= max) {
//                    max = lionScore - apeachScore;
//                    answer = lion.clone();
//                }
//            }
//
//            return;
//        }
//
//        for(int i = 0; i < 11; i++) {
//            if(lion[i] <= apeach[i]) {
//                lion[i]++;
//                dfs(n, apeach, cnt + 1);
//                lion[i]--;
//            } else {
//                break;
//            }
//        }
//    }

    static int max;
    static int[] answer;
    static int[] lion;

    public int[] solution(int n, int[] info) {
        max = 0;
        answer = new int[]{-1};
        lion = new int[11];

        dfs(n, info, 0);

        return answer;
    }

    private void dfs(int n, int[] apeach, int cnt) {
        if(cnt == n) {
            int apeachScore = 0;
            int lionScore = 0;
            for(int i = 0; i < 11; i++) {
                if(apeach[i] == 0 && lion[i] == 0) continue;

                if(apeach[i] >= lion[i]) {
                    apeachScore += 10 - i;
                } else {
                    lionScore += 10 - i;
                }
            }

            if(apeachScore < lionScore) {
                if(lionScore - apeachScore >= max) {
                    max = lionScore - apeachScore;
                    answer = lion.clone();
                }
            }

            return;
        }

        for(int i = 0; i < 11; i++) {
            if(apeach[i] >= lion[i]) {
                lion[i]++;
                dfs(n, apeach, cnt + 1);
                lion[i]--;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArcheryCompetition s = new ArcheryCompetition();
        s.solution(9, new int[]{0,0,1,2,0,1,1,1,1,1,1});
    }
}
