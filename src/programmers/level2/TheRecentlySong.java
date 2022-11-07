package programmers.level2;

public class TheRecentlySong {
    static int longestRunningTime = 0;

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        for(int i = musicinfos.length - 1; i >= 0; i--) {
            String[] arr = musicinfos[i].split(",");
            String[] startTimeArr = arr[0].split(":");
            String[] endTimeArr = arr[1].split(":");
            int startTime = parseTime(startTimeArr);
            int endTime = parseTime(endTimeArr);
            int runningTime = endTime - startTime;
            String title = arr[2];
            String song = exchange(arr[3]);
            m = exchange(m);

            int songLength = song.length();
            if(runningTime <= songLength) {
                song = song.substring(0, runningTime);
            } else {
                StringBuilder sb = new StringBuilder();
                int share = runningTime / songLength;
                int remainder = runningTime % songLength;
                for(int k = 0; k < share; k++) {
                    sb.append(song);
                }

                for(int k = 0; k < remainder; k++) {
                    sb.append(song.charAt(k));
                }
                song = sb.toString();
            }
//            System.out.println("trueSong = " + trueSong);

            if(song.contains(m) && runningTime >= longestRunningTime) {
                longestRunningTime = runningTime;
                answer = title;
            }
        }

        return answer;
    }

    private String exchange(String s) {
        s = s.replace("C#", "H");
        s = s.replace("D#", "I");
        s = s.replace("F#", "J");
        s = s.replace("G#", "K");
        s = s.replace("A#", "L");
        return s;
    }

    private int parseTime(String[] timeArr) {
        int hour = Integer.parseInt(timeArr[0]) * 60;
        int minute = Integer.parseInt(timeArr[1]);
        return hour + minute;
    }

    public static void main(String[] args) {
        TheRecentlySong s = new TheRecentlySong();
        s.solution("qwer", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }
}
