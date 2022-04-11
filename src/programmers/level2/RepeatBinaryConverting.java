package programmers.level2;

public class RepeatBinaryConverting {
    int tryCnt;
    int zeroDelCnt;

    public int[] solution(String s) {
        tryCnt = 0;
        zeroDelCnt = 0;

        binaryConvert(s);

        return new int[]{tryCnt, zeroDelCnt};
    }

    private void binaryConvert(String cur) {
        if(cur.equals("1")) return;

        int zeroCnt = 0;
        for(int i = 0; i < cur.length(); i++) {
            if(cur.charAt(i) == '0') zeroCnt++;
        }
        zeroDelCnt += zeroCnt;

        // 0 제거
        cur = cur.replace("0", "");

        // 이진법 변환
        int len = cur.length();
        StringBuilder num = new StringBuilder();
        while(len != 0) {
            num.append(len % 2);
            len /= 2;
        }

        tryCnt++;

        binaryConvert(num.toString());
    }
}
