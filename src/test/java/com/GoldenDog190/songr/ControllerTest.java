package com.GoldenDog190.songr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class ControllerTest {
    @Test
    public void testGettersAndSetters(){
        Album alby = new Album("X&Y", "Coldplay", 12, 3750,
                "https://upload.wikimedia.org/wikipedia/en/thumb/2/28/Coldplay_X%26Y.svg/480px-Coldplay_X%26Y.svg.png");
        assertEquals("X&Y", alby.title);
        assertEquals("Coldplay", alby.artist);
        assertEquals(12, alby.songCount);
        assertEquals(3750, alby.length);
        assertEquals("https://upload.wikimedia.org/wikipedia/en/thumb/2/28/Coldplay_X%26Y.svg/480px-Coldplay_X%26Y.svg.png", alby.imageUrl);

    }



}
