package programmers.level3;

import java.util.*;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: solution 참고
 */
public class WorryOfBrian {
    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();
        LinkedHashMap<Character, List<Integer>> markHavingIndexs = new LinkedHashMap<>();
        String invalid = "invalid";

        try {
            for(int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if(Character.isLowerCase(c)) {
                    if(!markHavingIndexs.containsKey(c)) {
                        markHavingIndexs.put(c, new ArrayList<>());
                    }
                    markHavingIndexs.get(c).add(i);
                }
            }

            int stringIdx = 0;
            int markStart, markEnd;
            int prevMarkStart = -1, prevMarkEnd = -1;
            int wordStart = 0, wordEnd = 0;
            int prevWordStart = -1, prevWordEnd = -1;
            int rule = 0, distance, count;

            List<Integer> curr;
            for(char c: markHavingIndexs.keySet()) {
                curr = markHavingIndexs.get(c);
                count = curr.size();
                markStart = curr.get(0);
                markEnd = curr.get(count - 1);

                if(count == 1 || count >= 3) {
                    for(int i = 1; i < count; i++) {
                        if(curr.get(i) - curr.get(i - 1) != 2) return invalid;
                    }
                    rule = 1;
                }else if (count == 2) {
                    distance = markEnd - markStart;

                    if(distance == 2 && (prevMarkStart < markStart && markEnd < prevMarkEnd)) {
                        rule = 1;
                    }else if(distance >= 2) {  // AaAaA -> A A A
                        rule = 2;
                    }else {
                        return invalid;
                    }
                }

                if(rule == 1) {
                    wordStart = markStart - 1;
                    wordEnd = markEnd + 1;

                    if(prevWordStart < wordStart && wordEnd < prevWordEnd) {
                        if(markStart - prevMarkStart == 2 && prevMarkEnd - markEnd == 2) continue;
                        else return invalid;
                    }
                }else if(rule == 2) {
                    wordStart = markStart;
                    wordEnd = markEnd;

                    if(prevWordStart < wordStart && wordEnd < prevWordEnd) return invalid;
                }

                if(wordStart <= prevWordEnd) return invalid;

                if(stringIdx < wordStart) {
                    answer.append(makeWord(sentence, stringIdx, wordStart));
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

    private String makeWord(String sentence, int start, int end) {
        String word = sentence.substring(start, end);
        return word.replaceAll("[a-z]", "");
    }
}
