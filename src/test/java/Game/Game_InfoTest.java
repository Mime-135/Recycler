package Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Game_InfoTest {

    @Before
    public void setUp() {
        System.out.println("I execute before each class");
    }

    @After
    public void tearDown() {
        System.out.println("I execute after each class");
    }

    @Test
    public void pick_Database_word_array() {
        //test to show create an array for the gameplay works
        Game_Info G1 = new Game_Info();
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.EasyDiffLevel_answer[i]);
            System.out.println(G1.EasyDiffLevel_data[i]);
        }
        G1.difficultyLevel = "Hard";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.HardDiffLevel_answer[i]);
            System.out.println(G1.HardDiffLevel_data[i]);
        }
        G1.difficultyLevel = "Normal";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.mediumDiffLevel_answer[i]);
            System.out.println(G1.mediumDiffLevel_data[i]);
        }
    }

    @Test
    public void set_game_all_param() {
        //Check that the game parameters are set properly
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.item_types);
        System.out.println(G1.difficultyLevel);
        System.out.println(G1.Timer);
        System.out.println(G1.max_number_items);
    }

    @Test
    public void get_word() {
        // Check if we are getting the right words from the array
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_word(2));
    }

    @Test
    public void get_counter() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_counter());
        assertEquals("Should be 0 at this stage", 0, G1.get_counter());
    }

    @Test
    public void get_container() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_container(2));
    }

    @Test
    public void get_max_number_items() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_max_number_items());
        assertEquals("Should be 5", 5, G1.get_max_number_items());
    }

    @Test
    public void get_score() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_score());
        assertEquals("Should be 0", 0, G1.get_score());
    }

    @Test
    public void get_calculated_score() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_calculated_score());

    }

    @Test
    public void get_answer() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_answer(2));
    }

    @Test
    public void get_Item_type() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.get_Item_type());
    }

    @Test
    public void get_Hard_database_word() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.difficultyLevel = "Hard";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.HardDiffLevel_answer[i]);
            System.out.println(G1.HardDiffLevel_data[i]);
        }
        System.out.println(G1.get_Hard_database_word(2));
    }

    @Test
    public void get_Normal_database_word() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.difficultyLevel = "Normal";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.mediumDiffLevel_answer[i]);
            System.out.println(G1.mediumDiffLevel_data[i]);
        }
        System.out.println(G1.get_Normal_database_word(3));
    }

    @Test
    public void get_Easy_database_word() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.EasyDiffLevel_answer[i]);
            System.out.println(G1.EasyDiffLevel_data[i]);
        }
        System.out.println(G1.get_Easy_database_word(1));
    }

    @Test
    public void getGame_Chosen() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        System.out.println(G1.getGame_Chosen());
        System.out.println(G1.Game_Chosen);
    }

    @Test
    public void get_Hard_database_image() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.difficultyLevel = "Hard";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.HardDiffLevel_answer[i]);
            System.out.println(G1.HardDiffLevel_data[i]);
        }
        System.out.println(G1.get_Hard_database_image(1));
    }

    @Test
    public void get_Normal_database_image() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.difficultyLevel = "Normal";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.mediumDiffLevel_answer[i]);
            System.out.println(G1.mediumDiffLevel_data[i]);
        }
        System.out.println(G1.get_Normal_database_image(2));
    }

    @Test
    public void get_Easy_database_image() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.EasyDiffLevel_answer[i]);
            System.out.println(G1.EasyDiffLevel_data[i]);
        }
        System.out.println(G1.get_Easy_database_image(3));
    }


    @Test
    public void increase_score() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.score = 20;
        G1.increase_score();
        System.out.println(G1.score);
        assertEquals("Increase the score value", 21, G1.score);
    }

    @Test
    public void increase_counter() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.counter = 2;
        G1.increase_counter();
        System.out.println(G1.counter);
    }

    @Test
    public void decrease_counter() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.counter = 2;
        G1.decrease_counter();
        System.out.println(G1.counter);
    }

    @Test
    public void reset_counter() {
        Game_Info G1 = new Game_Info();
        G1.reset_counter();
        assertEquals("Set counter to 0", 0,G1.counter);
        System.out.println("Counter reset");
    }

    @Test
    public void reset_score() {
        Game_Info G1 = new Game_Info();
        G1.reset_score();
        assertEquals("Set score to 0", 0,G1.score);
        System.out.println("Score reset");
    }

    @Test
    public void check_answer() {
        Game_Info G1 = new Game_Info();
        G1.set_game_all_param("Words","Easy",true,5);
        G1.Game_Chosen = "Easy";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.EasyDiffLevel_answer[i]);
            System.out.println(G1.EasyDiffLevel_data[i]);
        }
        G1.counter = 2;
        G1.user_current_word = G1.EasyDiffLevel_answer[G1.counter];
        G1.check_answer();
        System.out.println(G1.track_of_scores[G1.counter]);
        System.out.println("*******************************");

        G1.difficultyLevel = "Hard";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.HardDiffLevel_answer[i]);
            System.out.println(G1.HardDiffLevel_data[i]);
        }
        G1.counter = 2;
        G1.check_answer();
        System.out.println(G1.track_of_scores[G1.counter]);
        System.out.println("********************************");

        G1.difficultyLevel = "Normal";
        G1.pick_Database_word_array();
        for (int i = 0; i < 5; i++){
            System.out.println(G1.mediumDiffLevel_answer[i]);
            System.out.println(G1.mediumDiffLevel_data[i]);
        }
        G1.counter = 2;
        G1.check_answer();
        System.out.println(G1.track_of_scores[G1.counter]);
        System.out.println("*********************************");
    }
}