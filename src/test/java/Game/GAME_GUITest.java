package Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GAME_GUITest {

    @Before
    public void setUp() {
        System.out.println("I execute before each class");
    }

    @After
    public void tearDown() {
        System.out.println("I execute after each class");
    }

    @Test
    public void addComponentsToPane() {
        //Testing that the constructor works
        //The rest of the class depends in Java Swing which would be tested during interface and integration testing
        GAME_GUI gui = new GAME_GUI();
    }
}