package edu.pitt.se;

import org.junit.jupiter.api.Test;
import java.util.List;
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
        List<Integer> bpms = new ArrayList<Integer>();
        assertEquals("Invalid Size, List must contain at least one item", PlaylistRecommender.classifyEnergy(bpms));
        bpms = null;
        assertEquals("Invalid, List is null", PlaylistRecommender.classifyEnergy(bpms));

        List<Integer> bpms2 = new ArrayList<Integer>();
        bpms2.add(20);
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(bpms2));
        bpms2.add(240);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms2));
        bpms2.add(200);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms2));



    }

    @Test 
    public void testValidTrackTitle() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Abc123"));
        assertTrue(PlaylistRecommender.isValidTrackTitle("Playlist Test One"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("!-#$"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghij"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("This is my new playlist!"));

    }

    @Test 
    public void testNormalizeVolume() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
        assertEquals(0, PlaylistRecommender.normalizeVolume(-30));
        assertEquals(75, PlaylistRecommender.normalizeVolume(75));
    }
}
