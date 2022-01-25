package programmers.level3;

import java.util.*;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: solution 참고
 * 4차: solution 참고, AaAaA같은 반례를 stringIdx와 rule2로 구분해서 처리, rule4 처리
 */
public class WorryOfBrian {
    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        LinkedHashMap<Character, List<Integer>> markHavingIndexs = new LinkedHashMap<>();
        String invalid = "invalid";

        try {
            for(int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                if(Character.isLowerCase(ch)) {
                    if(!markHavingIndexs.containsKey(ch)) {
                        markHavingIndexs.put(ch, new ArrayList<>());
                    }
                    markHavingIndexs.get(ch).add(i);
                }
            }

            int markStart = 0, markEnd = 0;
            int prevMarkStart = -1, prevMarkEnd = -1;
            int wordStart = 0, wordEnd = 0;
            int prevWordStart = -1, prevWordEnd = -1;
            int count = 0, distance = 0, rule = 0;
            int stringIdx = 0;

            List<Integer> cur;
            for(char ch: markHavingIndexs.keySet()) {
                cur = markHavingIndexs.get(ch);
                count = cur.size();
                markStart = cur.get(0);
                markEnd = cur.get(count - 1);

                // rule1 인지 rule2 인지 이도저도 아닌지 구분
                if(count == 1 || count >= 3) {  // rule 1
                    for(int i = 1; i < count; i++) {
                        if(cur.get(i) - cur.get(i - 1) != 2) {  // mark가 다른 단어에도 쓰임
                            return invalid;
                        }
                    }
                    rule = 1;
                }else if(count == 2) {  // rule1 or rule2
                    distance = markEnd - markStart;
                    if(distance == 2 && prevMarkStart < markStart && markEnd < prevMarkEnd) {
                        rule = 1;
                    }else if(distance >= 2) {
                        rule = 2;
                    }else {
                        return invalid;  // mark가 다른 단어에도 쓰임
                    }
                }

                // rule1과 rule2 중첩 불가
                if(rule == 1) {
                    wordStart = markStart - 1;
                    wordEnd = markEnd + 1;
                    if(prevWordStart < wordStart && wordEnd < prevWordEnd) {  // rule1 과 rule2가 동시에 쓰인 단어
                        if(markStart - prevMarkStart == 2 && prevMarkEnd - markEnd == 2) continue;
                        return invalid;  // rule1 중첩
                    }
                }else if(rule == 2) {
                    wordStart = markStart;
                    wordEnd = markEnd;
                    if(prevWordStart < wordStart && wordEnd < prevWordEnd) return invalid;  // rule2 중첩
                }

                if(wordStart <= prevWordEnd) return invalid;  // 이전 word와 현재 word 겹침

                // answer append
                if(stringIdx < wordStart) {
                    answer.append(makeWord(sentence, stringIdx, wordStart));  // AaAaA 같은 반례를 위한 조건문
                    answer.append(" ");
                }
                answer.append(makeWord(sentence, wordStart, wordEnd + 1));
                answer.append(" ");

                prevWordStart = wordStart;
                prevWordEnd = wordEnd;
                prevMarkStart = markStart;
                prevMarkEnd = markEnd;
                stringIdx = wordEnd + 1;
            }

            if(stringIdx < sentence.length()) {
                answer.append(makeWord(sentence, stringIdx, sentence.length()));
            }
        } catch (Exception e) {
            return invalid;
        }

        return answer.toString().trim();
    }

    private String makeWord(String sentence, int from, int to) {
        String result = sentence.substring(from, to);
        return result.replaceAll("[a-z]", "");
    }
}
