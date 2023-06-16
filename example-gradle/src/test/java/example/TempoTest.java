package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TempoTest {
    @Test
    public void bpm() {
        Assertions.assertEquals(100, new Tempo(100).getBpm());
    }
}