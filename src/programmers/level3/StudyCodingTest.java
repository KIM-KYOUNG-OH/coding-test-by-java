package programmers.level3;

public class StudyCodingTest {
    public int solution(int alp, int cop, int[][] problems) {
        int goalAlp = 0;
        int goalCop = 0;

        for(int i = 0; i < problems.length; i++) {
            goalAlp = Math.max(problems[i][0], goalAlp);
            goalCop = Math.max(problems[i][1], goalCop);
        }

        if(goalAlp <= alp && goalCop <= cop) {
            return 0;
        }

        if(alp >= goalAlp) {
            alp = goalAlp;
        }

        if(cop >= goalCop) {
            cop = goalCop;
        }

        int[][] dp = new int[goalAlp + 2][goalCop + 2];

        for(int i = alp; i <= goalAlp; i++) {
            for(int j = cop; j <= goalCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0;
        
        for(int i = alp; i <= goalAlp; i++) {
            for(int j = cop; j <= goalCop; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                
                for(int[] p : problems) {
                    int alp_req = p[0];
                    int cop_req = p[1];
                    int alp_rwd = p[2];
                    int cop_rwd = p[3];
                    int cost = p[4];
                    if(i >= alp_req && j >= cop_req) {
                        if(i + alp_rwd > goalAlp && j + cop_rwd > goalCop) {
                            dp[goalAlp][goalCop] = Math.min(dp[goalAlp][goalCop], dp[i][j] + cost);
                        } else if(i + alp_rwd > goalAlp) {
                            dp[goalAlp][j + cop_rwd] = Math.min(dp[goalAlp][j + cop_rwd], dp[i][j] + cost);
                        } else if(j + cop_rwd > goalCop) {
                            dp[i + alp_rwd][goalCop] = Math.min(dp[i + alp_rwd][goalCop], dp[i][j] + cost);
                        } else {
                            dp[i + alp_rwd][j + cop_rwd] = Math.min(dp[i + alp_rwd][j + cop_rwd], dp[i][j] + cost);
                        }
                    }
                }
            }
        }

        return dp[goalAlp][goalCop];
    }
}
