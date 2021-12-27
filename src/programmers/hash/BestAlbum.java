package programmers.hash;

import java.util.*;

public class BestAlbum {
    static class Song {
        private String genre;
        private int play;
        private int idx;

        public Song(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 장르별 노래 재생수
        Map<String, Integer> genrePlayCnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCnt.put(genres[i], genrePlayCnt.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르 노래 재생수 순 정렬
        List<String> sortedGenres = new ArrayList<>();
        while(genrePlayCnt.size() != 0) {
            int maxCnt = -1;
            String maxGenre = "";
            for (String key : genrePlayCnt.keySet()) {
                if(maxCnt <= genrePlayCnt.get(key)) {
                    maxCnt = genrePlayCnt.get(key);
                    maxGenre = key;
                }
            }
            sortedGenres.add(maxGenre);
            genrePlayCnt.remove(maxGenre);
        }

        // 장르별 두 개까지 결과에 추가
        List<Song> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> temp = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genre)) {
                    Song song = new Song(genre, plays[i], i);
                    temp.add(song);
                }
                // 고유번호순 정렬 후 재생 play순 정렬
                Collections.sort(temp, ((o1, o2) -> o1.idx - o2.idx));
                Collections.sort(temp, ((o1, o2) -> o2.play - o1.play));
            }
            result.add(temp.get(0));
            if(temp.size() > 1) {
                result.add(temp.get(1));
            }
        }

        // 결과의 idx를 answer에 담기
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).idx;
        }

        return answer;
    }
}
