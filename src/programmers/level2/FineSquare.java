package programmers.level2;

/**
 * 1차: solution 참고, 유클리드 호제법, 타입 변환
 * 2차: 통과
 */
public class FineSquare {
//    public long solution(int w, int h) {
//
//        long wide = w;
//        long height = h;
//
//        if(wide < height) {
//            long temp = wide;
//            wide = height;
//            height = temp;
//        }
//
//        long gcd = getGcd(wide, height);
//
//        long answer = (wide * height) - (wide / gcd + height / gcd - 1) * gcd;
//
//        return answer;
//    }
//
//    private long getGcd(long a, long b) {
//        if(b == 0) {
//            return a;
//        }
//        return getGcd(b, a % b);
//    }
    public long solution(int w, int h) {
        long wide = w;
        long height = h;
        long answer = wide * height;

        if(height > wide) {
            long temp = wide;
            wide = height;
            height = temp;
        }

        long gcd = getGcd(wide, height);

        answer -= ((wide / gcd) + (height / gcd) - 1) * gcd;

        return answer;
    }

    private long getGcd(long a, long b) {
        if(b == 0) return a;
        return getGcd(b, a % b);
    }
}
