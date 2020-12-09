package GUI;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AboutUsTest {
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
    public void main() {
       new AboutUs();

    }
}