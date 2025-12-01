package edu.pitt.se;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.beans.Transient;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistRecommenderTest {
    @Test
    public void testClassifyEnergyNullList() {
        // null list
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(null));
    }

    @Test
    public void testClassifyEnergyEmptyList() {
        List<Integer> bpms = new ArrayList<Integer>();
        // empty list
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.classifyEnergy(bpms));
    }

    @Test
    public void testClassifyEnergy() {
        List<Integer> bpms2 = new ArrayList<Integer>();
        // Low Energy
        bpms2.add(20);
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(bpms2));

        // Medium Energy
        bpms2.add(240);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms2));

        // High Energy
        bpms2.add(200);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms2));
    }

    @Test
    public void testValidTrackTitleNull() {
        // null title
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.isValidTrackTitle(null));
    }

    @Test
    public void testValidTrackTitleInvalidLength() {
        // String Less than 1 char
        assertThrows(IllegalArgumentException.class, () -> PlaylistRecommender.isValidTrackTitle(""));
        // String longer than 30 char
        assertThrows(IllegalArgumentException.class,
                () -> PlaylistRecommender.isValidTrackTitle("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghij"));

    }

    @Test
    public void testValidTrackTitle() {
        // testing spaces
        assertTrue(PlaylistRecommender.isValidTrackTitle("Playlist Test One"));
        // upper and lower case 
        assertTrue(PlaylistRecommender.isValidTrackTitle("MyPlaylist"));
        // minimum length
        assertTrue(PlaylistRecommender.isValidTrackTitle("A"));


        // testing alpha-numeric
        assertFalse(PlaylistRecommender.isValidTrackTitle("Abc123"));
        // testing invalid characters
        assertFalse(PlaylistRecommender.isValidTrackTitle("!-#$"));
        assertFalse(PlaylistRecommender.isValidTrackTitle("Efg-123"));
        
        // testing a string with a single invalid character
        assertFalse(PlaylistRecommender.isValidTrackTitle("This is my new playlist!"));

    }

    @Test
    public void testNormalizeVolume() {
        // Volume greater than 100
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
        // Volume less than 0
        assertEquals(0, PlaylistRecommender.normalizeVolume(-30));
        // Volume within range
        assertEquals(75, PlaylistRecommender.normalizeVolume(75));
    }
}
