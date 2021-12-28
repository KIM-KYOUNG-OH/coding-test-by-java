package programmers.stackAndQueue;

import java.util.*;

public class TruckPassingBridge {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> onBridge = new LinkedList<>();

        int max = 0;
        for (int w : truck_weights) {
            while(true) {
                if(onBridge.isEmpty()) {
                    answer++;
                    max += w;
                    onBridge.add(w);
                    break;
                }else if(onBridge.size() == bridge_length) {
                    max -= onBridge.poll();
                }else {
                    if(w + max > weight) {
                        onBridge.add(0);
                        answer++;
                    }else{
                        onBridge.add(w);
                        answer++;
                        max += w;
                        break;
                    }
                }
            }
        }

        return answer + bridge_length;
    }

}
