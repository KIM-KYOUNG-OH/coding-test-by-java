package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeStar {
    long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
    long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

    public String[] solution(int[][] line) {
        String[] answer = {};
        Set<Coordinate> set = new HashSet<>();

        for(int i = 0; i < line.length - 1; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            for(int j = i + 1; j < line.length; j++) {
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];

                long ADBC = A * D - B * C;
                if(ADBC == 0) continue;

                long BFED = B * F - E * D;
                if(BFED % ADBC != 0) continue;

                long ECAF = E * C - A * F;
                if(ECAF % ADBC != 0) continue;

                long y = ECAF / ADBC;
                long x = BFED / ADBC;
                set.add(new Coordinate(y, x));
                minY = Math.min(minY, y);
                minX = Math.min(minX, x);
                maxY = Math.max(maxY, y);
                maxX = Math.max(maxX, x);
            }
        }

        long height = maxY - minY + 1;
        long width = maxX - minX + 1;
        answer = new String[(int) height];
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < width; i++) {
            s.append(".");
        }

        Arrays.fill(answer, s.toString());

        for(Coordinate coordinate: set) {
            long ny = maxY - coordinate.y;
            long nx = coordinate.x - minX;
            answer[(int) ny] = answer[(int) ny].substring(0, (int) nx) + "*"
                    + answer[(int) ny].substring((int) (nx + 1));
        }

        return answer;
    }

    private static class Coordinate {
        long y;
        long x;

        public Coordinate(long y, long x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        MakeStar s = new MakeStar();
        s.solution(new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}});
    }
}
