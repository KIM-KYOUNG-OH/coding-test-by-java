package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class MultiLevelToothbrushSales {
    private Map<String, Integer> resultMap;
    private Map<String, String> parentMap;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        resultMap = new HashMap<>();
        parentMap = new HashMap<>();

        for(int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            resultMap.put(enroll[i], 0);
        }

        for(int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            result[i] = resultMap.get(enroll[i]);
        }

        return result;
    }

    private void dfs(String child, int money) {
        if(child.equals("-") || money < 1) {
            return;
        }

        int parentMoney = (int) Math.floor(money * 0.1);
        int childMoney = money - parentMoney;
        resultMap.replace(child, resultMap.get(child) + childMoney);

        dfs(parentMap.get(child), parentMoney);
    }

    public static void main(String[] args) {
        MultiLevelToothbrushSales s = new MultiLevelToothbrushSales();
        s.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"}, new int[]{12, 4, 2, 5, 10});
    }
}
