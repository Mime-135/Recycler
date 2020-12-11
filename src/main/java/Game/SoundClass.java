package Game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SoundClass {

    public SoundClass() { // Constructor
    }
    //Function to play a song in the background while the game is being played
    public void playSong(){
        SourceDataLine soundLine = null;
        int BUFFER_SIZE = 64 * 1024;  // 64 KB

        // Set up an audio input stream piped from the sound file.

        try {
            Path path = Paths.get("src\\main\\java\\Sound\\music_dave_miles_get_the_groove.wav");
            String location = String.valueOf(path.toAbsolutePath()); //holds the image path
            File soundFile = new File(location);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile); //Audiostream to take in the sound file
            AudioFormat audioFormat = audioInputStream.getFormat(); // Returns the format of the sound file
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            soundLine = (SourceDataLine) AudioSystem.getLine(info);
            soundLine.open(audioFormat); // Open the sound line to start playing the song
            soundLine.start(); // Play the song
            int nBytesRead = 0;
            byte[] sampledData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
                if (nBytesRead >= 0) {
                    // Writes audio data to the mixer via this source data line.
                    soundLine.write(sampledData, 0, nBytesRead);
                }
            }
        } catch (UnsupportedAudioFileException ex) { // In case the file is not supported
            ex.printStackTrace();
        } catch (IOException ex) { // In case the file is interrupted
            ex.printStackTrace();
        } catch (LineUnavailableException ex) { // In case the line cannot be opened
            ex.printStackTrace();
        } finally {
            soundLine.drain(); //drains data from song until it is empty
            soundLine.close(); //close the output stream

        }
    }

}