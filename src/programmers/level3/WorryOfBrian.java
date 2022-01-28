package programmers.level3;

import java.util.*;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: solution 참고
 * 4차: solution 참고, AaAaA같은 반례를 stringIdx와 rule2로 구분해서 처리, rule4 처리
 * 5차: 그만 풀기로 하자
 */
public class WorryOfBrian {

    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        String invalid = "invalid";
        LinkedHashMap<Character, List<Integer>> lowerHavingIndexs = new LinkedHashMap<>();
        try {
            for(int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                if(Character.isLowerCase(ch)) {
                    if(!lowerHavingIndexs.containsKey(ch)) {
                        lowerHavingIndexs.put(ch, new ArrayList<>());
                    }
                    lowerHavingIndexs.get(ch).add(i);
                }
            }

            int lowerStart = 0, lowerEnd = 0;
            int prevLowerStart = -1, prevLowerEnd = -1;
            int wordStart = 0, wordEnd = 0;
            int prevWordStart = -1, prevWordEnd = -1;
            int rule = 0, distance = 0, stringIdx = 0, count = 0;

            List<Integer> cur;
            for(char ch: lowerHavingIndexs.keySet()) {
                cur = lowerHavingIndexs.get(ch);
                count = cur.size();
                lowerStart = cur.get(0);
                lowerEnd = cur.get(count - 1);

                if(count == 1 || count >= 3) {  // rule 1
                    for(int i = 1; i < count; i++) {
                        if(cur.get(i) - cur.get(i - 1) != 2) {
                            return invalid;
                        }
                    }
                    rule = 1;
                }else if(count == 2) {  // rule 1 or rule 2
                    distance = lowerEnd - lowerStart;
                    if(distance == 2 && prevLowerStart < lowerStart && lowerEnd < prevLowerEnd) {
                        rule = 1;
                    }else if(distance >= 2) {
                        rule = 2;
                    }else return invalid;
                }

                if(rule == 1) {
                    wordStart = lowerStart - 1;
                    wordEnd = lowerEnd + 1;
                    if(prevWordStart < wordStart && wordEnd < prevWordEnd) {
                        if(lowerStart - prevLowerStart == 2 && prevLowerEnd - lowerEnd == 2) continue;
                        return invalid;
                    }
                }else if(rule == 2) {
                    wordStart = lowerStart;
                    wordEnd = lowerEnd;
                    if(prevWordStart < wordStart && wordEnd < prevWordEnd) {
                        return invalid;
                    }
                }

                if(wordStart <= prevWordEnd) return invalid;

                if(stringIdx < wordStart) {
                    answer.append(makeStr(sentence, stringIdx, wordStart));
                    answer.append(" ");
                }

                answer.append(makeStr(sentence, wordStart, wordEnd + 1));
                answer.append(" ");

                stringIdx = wordEnd + 1;
                prevLowerStart = lowerStart;
                prevLowerEnd = lowerEnd;
                prevWordStart = wordStart;
                prevWordEnd = wordEnd;
            }

            if(stringIdx < sentence.length()) {
                answer.append(makeStr(sentence, stringIdx, sentence.length()));
            }
        } catch (Exception e) {
            return invalid;
        }

        return answer.toString().trim();
    }

    private String makeStr(String sentence, int from, int to) {
        String s = sentence.substring(from, to);
        String result = s.replaceAll("[a-z]","");
        return result;
    }

    public static void main(String[] args) {
        WorryOfBrian s = new WorryOfBrian();
        System.out.println(s.solution("SpIpGpOpNpGJqOqA"));
    }
}
