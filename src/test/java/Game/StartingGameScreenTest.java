package Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartingGameScreenTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("I execute before each class");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("I execute after each class");
    }

    @Test
    public void run() {
        //To test that the start game screen is set up properly
        StartingGameScreen start = new StartingGameScreen();
        start.run();
        System.out.println("Started game screen");
    }

    @Test
    public void get_Theme() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void get_Difficulty() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void get_Item_type() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void get_Item_num() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }

    @Test
    public void get_Timer() {
        //Java Swing GUI
        //Function tested during black box testing when running the game, interface testing and integration testing.
        //It depends on clicked radio buttons.
    }
}