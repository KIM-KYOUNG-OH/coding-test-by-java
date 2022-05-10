package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P216_CombinationSum3 {
    List<List<Integer>> result;
    List<Integer> current;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        current = new ArrayList<>();

        if(k * (k + 1) / 2 > n) {
            return result;
        }

        dfs(1, k, n);

        return result;
    }

    private void dfs(int start, int k, int sum) {
        if(sum < 0) return;

        if(sum == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < 10; i++) {
            current.add(i);
            dfs(i + 1, k, sum - i);
            current.remove(current.size() - 1);
        }
    }
}
