package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameSettingsTest {

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
    public void get_Difficulty() {
        GameSettings g = new GameSettings();
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