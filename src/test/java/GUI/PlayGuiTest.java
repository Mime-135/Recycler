package GUI;

import Game.Game_Info;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class PlayGuiTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("I execute before each class");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("I execute after each class");
    }

    @Test
    public void start_word_or_images() throws IOException {
        PlayGui P1 = new PlayGui();
        P1.start_word_or_images();
        System.out.println("Word or Images selected");
    }

    @Test
    public void display_word_from_database() throws IOException {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void display_image_from_database() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void updateGameStats() throws IOException {
        //Checks that the latest score is updated in the Game Statistics text file
        PlayGui P1 = new PlayGui();
        P1.updateGameStats(20.0);

        double a = 0,b = 0,c = 0; // These variables will hold the latest, best and worst scores

        Path path = Paths.get("src\\main\\java\\GamePlay Info\\Game Statistics.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file)); // reads in the String from the character stream
        String st;

        while((st= br.readLine())!=null){ //read in the line and separate all the scores by a -
            String[] num = st.split("-"); // store them in a, b, c
            a= Double.parseDouble(num[0]);
            b= Double.parseDouble(num[1]);
            c= Double.parseDouble(num[2]);
        }
        br.close(); //close the file stream
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("Game statistics text file has been updated");
    }

    @Test
    public void give_userInput_for_ScoreChecking() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void setting_Radio_buttons() throws IOException {
        //Check that the radio buttons in the game play are set properly. This function would be tested
        //properly during integration and interface testing
        PlayGui P1 = new PlayGui();
        P1.setting_Radio_buttons();
        System.out.println("Radio Buttons set");
    }

    @Test
    public void setting_containers() throws IOException {
        //Check that the bins are correctly resized and added to the main panel correctly
        PlayGui P1 = new PlayGui();
        P1.setting_containers();
        System.out.println("Containers set");
    }

    @Test
    public void resize_containers() throws IOException {
        PlayGui  P1 = new PlayGui();
        String filename = "src/main/java/Bins/Bottles-Cans.jpg";
        P1.resize_containers(filename, 100, 100);
        System.out.println("Done resizing");
    }

    @Test
    public void setGameGUIParam() throws IOException {
        PlayGui  P1 = new PlayGui();
        P1.SetGameGUIParam("Easy","Image",true,5);
        System.out.println("Game parameters set");
    }

    @Test
    public void reset() throws IOException {
        PlayGui P1 = new PlayGui();
        P1.timerGame.start();
        P1.reset();
        System.out.println("Timer reset");
    }


}