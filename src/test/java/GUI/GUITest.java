package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GUITest {

    @BeforeClass
    public static void createB(){
        System.out.println("I execute before the class");
    }

    @After
    public void after(){
        System.out.println("I execute after each class");
    }

    @Before
    public void before(){
        System.out.println("I execute before each class");
    }

    @Test
    public void GUI() {
        //Testing the constructor. Should create the game start screen
        GUI g = new GUI();
    }

    @Test
    public void playGame() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //Also partly tested in the run test function
    }

    @Test
    public void howToPlay() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //Also partly tested in the run test function
    }

    @Test
    public void setting() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //Also partly tested in the run test function
    }

    @Test
    public void gameStatistics() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //Also partly tested in the run test function
    }

    @Test
    public void aboutUs() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //Also partly tested in the run test function
    }

    @Test
    public void run() {
        // Create an object of the GUI class and run it
        GUI g = new GUI();
        g.run();
    }
}