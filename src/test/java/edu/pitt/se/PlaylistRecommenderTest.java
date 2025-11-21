package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {
    // assert...(expected, actual, optionalMessage)
    // assertEquals(expected, actual)
    // assertTrue(condition)
    // assertFalse(condition)
    // assertNotNull(object)
    // assertThrows(Exception.class, () -> { ... })

    @Test
    public String testClassifyEnergy() {
        assertEquals("Invalid Size, List must contain at least one item", PlaylistRecommender.classifyEnergy(null));

    }

    @Test 
    public boolean testValidTrackTitle() {
        assertTrue(true);
    }

    @Test 
    public int testNormalizeVolume() {
        assertEquals(True);
    }
}
