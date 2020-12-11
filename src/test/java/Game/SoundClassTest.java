package Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoundClassTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("I execute before each class");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("I execute after each class");
    }

    @Test
    public void playSong() {
        //Testing that the game background sound works
        SoundClass soundTest = new SoundClass();
        soundTest.playSong();
        System.out.println("Song playback complete!");
    }
}