package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GameStatisticsTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("I execute before each class");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("I execute after each class");
    }

    @Test
    public void main() throws IOException {
        //Testing the AboutUs constructor.
        //Most of the class is JavaSwing, which can be tested in the integration and interface test
        GameStatistics g = new GameStatistics();
    }
}