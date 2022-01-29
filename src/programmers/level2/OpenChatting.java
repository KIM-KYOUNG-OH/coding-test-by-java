package programmers.level2;

import java.util.*;

public class OpenChatting {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for(String rec: record) {
            String[] recList = rec.split(" ");
            if(recList[0].equals("Enter") || recList[0].equals("Change")) {
                map.put(recList[1], recList[2]);
            }
        }

        List<String> result = new ArrayList<>();
        for(String rec: record) {
            String[] recList = rec.split(" ");
            if(recList[0].equals("Enter")) {
                result.add(map.get(recList[1]) + "님이 들어왔습니다.");
            }else if(recList[0].equals("Leave")) {
                result.add(map.get(recList[1]) + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
