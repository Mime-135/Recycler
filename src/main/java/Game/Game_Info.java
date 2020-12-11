package Game;
import java.util.*;
public class Game_Info extends Data implements Game_parameters {
    protected int max_number_items=5; // num of items
    protected int counter=0; // counter will record item number
    protected int score=0; // score will record current score
    protected String difficultyLevel= "";
    protected String item_types = "";
    protected boolean Timer = false;
    protected String user_current_word;
    //Which array is selected
    protected String [] HardDiffLevel_data;
    protected String [] HardDiffLevel_answer;
    protected String [] mediumDiffLevel_data;
    protected String [] mediumDiffLevel_answer;
    protected String [] EasyDiffLevel_data;
    protected String [] EasyDiffLevel_answer;
    protected String Game_Chosen = "";
    protected String [] answer= {"Bottles/Cans","E-Waste","Mixed Paper","Organics","Plastics","Trash"};
    protected String[] items = {"Vase", "Cans", "Sandwich", "Punch Bowl","Bong"};
    protected String[] answers = {"Glass", "Metal", "Organic", "Glass","Glass"};
    protected String[] container = {"Glass","Metal","Organic"};
    protected String[] track_of_scores = {"","","","","","","","","","","","","","",""}; //record yes for correct, no for wrong
    protected static List<Double> array_full_of_scores; // we want this to be static
    public Data Database = new Data();
    public Game_Info(){
    }


    //store the Difficulty level from the database
    //if the user selects word option then this function will pick the database
    public void pick_Database_word_array(){
        int size = max_number_items;
        int[] arr = new int[size];
        arr = Database.playIndex(max_number_items);
        if(difficultyLevel.equals("Hard")){
            HardDiffLevel_data = Database.HardWordData(arr, size);
            HardDiffLevel_answer = Database.HardAnsData(arr, size);
            Game_Chosen = "Hard";
        }
        else if(difficultyLevel.equals("Normal")){
            mediumDiffLevel_data = Database.MediumWordData(arr, size);
            mediumDiffLevel_answer = Database.MediumAnsData(arr, size);
            Game_Chosen = "Normal";
        }
        else{ //difficulty is easy
            EasyDiffLevel_data = Database.EasyWordData(arr, size);
            EasyDiffLevel_answer = Database.EasyAnsData(arr, size);
            Game_Chosen = "Easy";
        }
    }

    //helps with intializing the PlayGUI parameters and is a setter for all the game parameters
    //Takes in Difficulty_Level, image/words, Timer, and Max_Num of Items
    public void set_game_all_param(String param2, String param3, boolean param4, int param5 ){
        this.item_types= param3;
        this.difficultyLevel = param2;
        this.Timer = param4;
        this.max_number_items = param5;
    }

    //Simple getters functions
    public String get_word(int i){ //i has to be between 0 and 5
        return this.items[i];
    }
    public int get_counter(){ //i has to be between 0 and 5
        return this.counter;
    }
    public int get_max_number_items(){ //i has to be between 0 and 5
        return this.max_number_items;
    }
    public String get_Item_type(){return this.item_types;}
    public String getGame_Chosen(){
        return Game_Chosen;
    }


    //Return a words from the difficulty level database array
    //Takes in index counter for the array
    public String get_Hard_database_word(int counter_game){
        return HardDiffLevel_data[counter_game];
    }
    public String get_Normal_database_word(int counter_game){
        return mediumDiffLevel_data[counter_game];
    }
    public String get_Easy_database_word(int counter_game){
        return EasyDiffLevel_data[counter_game];
    }

    //Return a Images from the difficulty level database array
    //get Hard image
    public String get_Hard_database_image(int counter_game){
        String temp = HardDiffLevel_data[counter_game];
        return "src/main/java/RecyclingImages/" + temp + ".jpg"; //filename to image
    }
    //get Normal image
    public String get_Normal_database_image(int counter_game){
        String temp = mediumDiffLevel_data[counter_game];
        return "src/main/java/RecyclingImages/" + temp + ".jpg"; //filename to image
    }
    //get easy image
    public String get_Easy_database_image(int counter_game){
        String temp = EasyDiffLevel_data[counter_game];
        return "src/main/java/RecyclingImages/" + temp + ".jpg"; //filename to image
    }



    //return a percentage for the final score of the PlaYGUI
    public double get_calculated_score(){ //i has to be between 0 and 5
        double temp_score=0;
        for(int i=0; i<this.max_number_items;i++) {
            if(this.track_of_scores[i].equals("yes")) {
                temp_score +=1;
            }
        }
        return (temp_score/this.max_number_items) *100;
    }


    //Takes in current user selected word from PlayGUI
    public void set_Current_user_word(String current_word){
        this.user_current_word = current_word;
    }

    // useful features
    public void increase_score(){ //i has to be between 0 and 5
        this.score = this.score +1;
    }
    public void increase_counter(){
        if(this.counter == max_number_items-1){
            //do nothing
        }
        else{
            this.counter = this.counter+1;
        }
    }
    public void decrease_counter(){
        if(this.counter == 0){
            //do nothing
        }
        else{
            this.counter = this.counter-1;
        }
    }

    //Increases The scores if the User Selected Answer is same as answer Array using counter and array index
    public void check_answer(){
        //Hard
        if(Game_Chosen.equals("Hard")){
            if(user_current_word.equals(HardDiffLevel_answer[this.counter])){
                increase_score();
                this.track_of_scores[this.counter] = "yes";
            }
            else{
                this.track_of_scores[this.counter] = "no";
            }
        }
        //Normal
        if(Game_Chosen.equals("Normal")){
            if(user_current_word.equals(mediumDiffLevel_answer[this.counter])){
                increase_score();
                this.track_of_scores[this.counter] = "yes";
            }
            else{
                this.track_of_scores[this.counter] = "no";
            }
        }
        //Easy
        if(Game_Chosen.equals("Easy")){
            if(user_current_word.equals( EasyDiffLevel_answer[this.counter])){
                increase_score();
                this.track_of_scores[this.counter] = "yes";
            }
            else{
                this.track_of_scores[this.counter] = "no";
            }
        }
    }

}
