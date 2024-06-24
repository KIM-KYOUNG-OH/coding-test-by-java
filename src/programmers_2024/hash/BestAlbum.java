package programmers_2024.hash;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {

        int n = genres.length;
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> currentGenreCnt = new HashMap<>();
        Map<String, Integer> genrePlayCnt = new HashMap<>();
        List<Album> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Album album = new Album(i, genres[i], plays[i]);
            list.add(album);
            genrePlayCnt.put(genres[i], genrePlayCnt.getOrDefault(genres[i], 0) + plays[i]);
        }


        list.sort(Comparator.comparing((Album a) -> genrePlayCnt.get(a.getGenre()), Comparator.reverseOrder())
                .thenComparing(Album::getPlay, Comparator.reverseOrder())
                .thenComparing(Album::getId));

        for (Album album : list) {
            if (currentGenreCnt.getOrDefault(album.getGenre(), 0) >= 2) {
                continue;
            }

            answer.add(album.getId());
            currentGenreCnt.put(album.getGenre(), currentGenreCnt.getOrDefault(album.getGenre(), 0) + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Album {

        private int id;
        private String genre;
        private int play;

        public Album(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        public int getId() {
            return id;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        @Override
        public String toString() {
            return "Album{" +
                    "id=" + id +
                    ", genre='" + genre + '\'' +
                    ", play=" + play +
                    '}';
        }
    }

    public static void main(String[] args) {
        BestAlbum s = new BestAlbum();
        s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }
}
