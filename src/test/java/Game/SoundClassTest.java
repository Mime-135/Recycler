package Game;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoundClassTest {

    @Test
    public void playSong() {
        //Testing that the game background sound works
        SoundClass soundTest = new SoundClass();
        soundTest.playSong();
        System.out.println("Song playback complete!");
    }
}