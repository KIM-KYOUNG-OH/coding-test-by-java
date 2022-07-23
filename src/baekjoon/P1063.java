package baekjoon;

import java.io.*;

public class P1063 {
    static String king = null;
    static String rock = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        king = s[0];
        rock = s[1];
        int t = Integer.parseInt(s[2]);
        for (int i = 0; i < t; i++) {
            String order = br.readLine();

            if(isRockInPathOfKing(order, king, rock)) {
                // 돌이 체스판을 벗어날 시 continue
                if(!isMovable(order, rock) || !isMovable(order, king)) continue;

                // 킹과 돌 이동
                rock = move(order, rock);
                king = move(order, king);
            } else {
                // 킹이 체스판을 벗어날 시 continue
                if(!isMovable(order, king)) continue;

                // 킹만 이동
                king = move(order, king);
            }
        }

        bw.write(king + "\n");
        bw.write(rock);

        br.close();
        bw.close();
    }

    private static String move(String order, String cur) {
        switch (order) {
            case "R":
                cur = (char) (cur.charAt(0) + 1) + "" + cur.charAt(1);
                break;
            case "L":
                cur = (char) (cur.charAt(0) - 1) + "" + cur.charAt(1);
                break;
            case "B":
                cur = cur.charAt(0) + "" + (char) (cur.charAt(1) - 1);
                break;
            case "T":
                cur = cur.charAt(0) + "" + (char) (cur.charAt(1) + 1);
                break;
            case "RT":
                cur = (char) (cur.charAt(0) + 1) + "" + (char) (cur.charAt(1) + 1);
                break;
            case "LT":
                cur = (char) (cur.charAt(0) - 1) + "" + (char) (cur.charAt(1) + 1);
                break;
            case "RB":
                cur = (char) (cur.charAt(0) + 1) + "" + (char) (cur.charAt(1) - 1);
                break;
            case "LB":
                cur = (char) (cur.charAt(0) - 1) + "" + (char) (cur.charAt(1) - 1);
                break;
        }

        return cur;
    }

    private static boolean isMovable(String order, String cur) {
        switch (order) {
            case "R":
                cur = (char) (cur.charAt(0) + 1) + "" + cur.charAt(1);
                break;
            case "L":
                cur = (char) (cur.charAt(0) - 1) + "" + cur.charAt(1);
                break;
            case "B":
                cur = cur.charAt(0) + "" + (char) (cur.charAt(1) - 1);
                break;
            case "T":
                cur = cur.charAt(0) + "" + (char) (cur.charAt(1) + 1);
                break;
            case "RT":
                cur = (char) (cur.charAt(0) + 1) + "" + (char) (cur.charAt(1) + 1);
                break;
            case "LT":
                cur = (char) (cur.charAt(0) - 1) + "" + (char) (cur.charAt(1) + 1);
                break;
            case "RB":
                cur = (char) (cur.charAt(0) + 1) + "" + (char) (cur.charAt(1) - 1);
                break;
            case "LB":
                cur = (char) (cur.charAt(0) - 1) + "" + (char) (cur.charAt(1) - 1);
                break;
        }

        return cur.charAt(0) >= 'A' && cur.charAt(0) <= 'H' && cur.charAt(1) >= '1' && cur.charAt(1) <= '8';
    }

    private static boolean isRockInPathOfKing(String order, String king, String rock) {
        switch (order) {
            case "R":
                if (rock.charAt(0) == (char)(king.charAt(0) + 1) && rock.charAt(1) == king.charAt(1)) return true;
                break;
            case "L":
                if (rock.charAt(0) == (char)(king.charAt(0) - 1) && rock.charAt(1) == king.charAt(1)) return true;
                break;
            case "B":
                if (rock.charAt(0) == king.charAt(0) && rock.charAt(1) == (char)(king.charAt(1) - 1)) return true;
                break;
            case "T":
                if (rock.charAt(0) == king.charAt(0) && rock.charAt(1) == (char)(king.charAt(1) + 1)) return true;
                break;
            case "RT":
                if (rock.charAt(0) == (char)(king.charAt(0) + 1) && rock.charAt(1) == (char)(king.charAt(1) + 1)) return true;
                break;
            case "LT":
                if (rock.charAt(0) == (char)(king.charAt(0) - 1) && rock.charAt(1) == (char)(king.charAt(1) + 1)) return true;
                break;
            case "RB":
                if (rock.charAt(0) == (char)(king.charAt(0) + 1) && rock.charAt(1) == (char)(king.charAt(1) - 1)) return true;
                break;
            case "LB":
                if (rock.charAt(0) == (char)(king.charAt(0) - 1) && rock.charAt(1) == (char)(king.charAt(1) - 1)) return true;
                break;
        }

        return false;
    }
}
