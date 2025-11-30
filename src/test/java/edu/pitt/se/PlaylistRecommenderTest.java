package edu.pitt.se;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {
    // assert...(expected, actual, optionalMessage)
    // assertEquals(expected, actual)
    // assertTrue(condition)
    // assertFalse(condition)
    // assertNotNull(object)
    // assertThrows(Exception.class, () -> { ... })

    @Test
    public void testClassifyEnergy() {
        // List<integer> empty = new ArrayList<>();
        // assertEquals("Invalid Size, List must contain at least one item", PlaylistRecommender.classifyEnergy(bpms));


    }

    @Test 
    public void testValidTrackTitle() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Abc123"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("Playlist Test One"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("!-#$"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghij"));

    }

    @Test 
    public void testNormalizeVolume() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-30));
        assertEquals(75, PlaylistRecommender.normalizeVolume(75));
    }
}
