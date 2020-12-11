package GUI;

import org.junit.Test;

import static org.junit.Assert.*;

public class HowToPlayGUITest {

    @Test
    public void displayInstructions() {
        HowToPlayGUI g = new HowToPlayGUI();
        g.displayInstructions();
        System.out.println(g);
    }

    @Test
    public void main() {

        //creating an object of the HowToPlayGUI to see if it works
        HowToPlayGUI g = new HowToPlayGUI();
    }
}