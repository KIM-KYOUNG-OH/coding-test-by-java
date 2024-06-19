package programmers2024.test.hash;

import org.junit.jupiter.api.Test;
import programmers2024.hash.AthletesFailedToFinish;

import static org.junit.jupiter.api.Assertions.*;

class AthletesFailedToFinishTest {

    @Test
    public void test1() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        AthletesFailedToFinish s = new AthletesFailedToFinish();
        String result = s.solution(participant, completion);

        assertEquals(result, "leo");
    }

    @Test
    public void test2() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        AthletesFailedToFinish s = new AthletesFailedToFinish();
        String result = s.solution(participant, completion);

        assertEquals(result, "vinko");
    }

    @Test
    public void test3() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        AthletesFailedToFinish s = new AthletesFailedToFinish();
        String result = s.solution(participant, completion);

        assertEquals(result, "mislav");
    }
}