package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.Assert.*;

public class SettingsTest {

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
    public void getTheme_color() {
        Settings g = new Settings();
        System.out.println(g.getTheme_color());
        Color color = new Color(0,170,0);
        assertEquals(color ,g.getTheme_color());
    }

    @Test
    public void getBackground_color() {
        Settings g = new Settings();
        System.out.println(g.getBackground_color());
        Color color = new Color(154,205,50);
        assertEquals(color ,g.getBackground_color());
    }

    @Test
    public void changeBackgroundColor() throws IOException {
        Settings g = new Settings();
        String[] col = {"Blue sky","Teal", "Olive", "Brown wooden", "Forest Green"};
        for (int i = 0; i < 5; i++){
            System.out.println(col[i]);
            g.changeBackgroundColor(col[i]);
        }
    }

    @Test
    public void changeTheme() {
        Settings g = new Settings();
        String[] col = {"Green","Dark Grey", "Navy", "Maroon"};
        for (int i = 0; i < 4; i++){
            System.out.println(col[i]);
            g.changeTheme(col[i]);
        }
    }

    @Test
    public void main() {
        //Test to see if the constructor creates a window with the settings page
        Settings g = new Settings();
    }
}