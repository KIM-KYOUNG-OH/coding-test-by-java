package programmers.level2;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: 통과, substring의 indexOutOfBoundException 발생 범위
 */
public class StringCompression {
//    public int solution(String s) {
//        int answer = s.length();
//
//        for(int i = 1; i <= s.length() / 2; i++) {
//            int compLen = compression(s, i).length();
//            answer = Math.min(answer, compLen);
//        }
//
//        return answer;
//    }
//
//    private String compression(String str, int i) {
//        int count = 1;
//        String compression = "";
//        String pattern = "";
//
//        for(int j = 0; j <= str.length() + i; j += i) {
//            String nowStr;
//
//            // 전 문자열과 비교할 현재 문자열
//            if(j >= str.length()) {  // 현재 문자열이 없을 때
//                nowStr = "";
//            }else if(str.length() < j + i) {  // 마지막 현재 문자열일 때
//                nowStr = str.substring(j);
//            }else {
//                nowStr = str.substring(j, j + i);
//            }
//
//            // 1. 전 문자열이랑 똑같은지 비교한다.(맨 처음이면 비교 X)
//            if(j != 0) {
//                if(nowStr.equals(pattern)) {  // 똑같으면
//                    count++;
//                }else if(count >= 2) {  // 다르고 count가 2회 이상이면 압축 가능
//                    compression += count + pattern;
//                    count = 1;
//                }else {  // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
//                    compression += pattern;
//                }
//            }
//
//            // 2. i 길이만큼 문자열을 자른다.
//            pattern = nowStr;
//        }
//
//        return compression;
//    }
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        for(int i = 1; i < len / 2 + 1; i++) {
            answer = Math.min(answer, compression(s, i).length());
        }

        return answer;
    }

    private String compression(String s, int i) {
        StringBuilder fixedStr = new StringBuilder();
        int cnt = 1;
        String cur;
        String pattern = "";
        for(int j = 0; j < s.length() + i; j += i) {
            if(s.length() <= j) {
                cur = "";
            }else if(s.length() < j + i) {
                cur = s.substring(j);
            }else {
                cur = s.substring(j, j + i);
            }

            if(j != 0) {
                if(cur.equals(pattern)) {
                    cnt++;
                }else if(cnt >= 2) {
                    fixedStr.append(cnt);
                    fixedStr.append(pattern);
                    cnt = 1;
                }else {
                    fixedStr.append(pattern);
                }
            }

            pattern = cur;
        }

        return fixedStr.toString();
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.solution("ababcdcdababcdcd"));
    }

}
