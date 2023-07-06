package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TempoTest {
    @Test
    public void testGetHz() {
        // Arrange
        Tempo tempo = new Tempo(120);

        // Act
        double hz = tempo.getHz();

        // Assert
        Assertions.assertEquals(2.0, hz);
    }

    @Test
    public void testToString() {
        // Arrange
        Tempo tempo = new Tempo(180);

        // Act
        String result = tempo.toString();

        // Assert
        Assertions.assertEquals("Tempo [bpm=180]", result);
    }
}
