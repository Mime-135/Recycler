package GUI;
import Game.GamePlayScreen;
import Game.Game_Info;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PlayGui implements GamePlayScreen {

    private final JFrame frame = new JFrame("RecycleMania");
    private final boolean save_game = false;
    private final boolean play_again = false;
    private final int score = 0;
    private JPanel main_panel;
    private JButton prevButton;
    private JPanel RecycleBin_1;
    private JPanel word_or_image_panel;
    private JButton nextButton;
    private JButton pauseButton;
    private JTextField progressTextField;
    private JButton exitButton;
    private JLabel progressLabel;
    private JLabel errorLabel;
    private JLabel TimerLabel;
    private JLabel time;

    private final JPanel panel=new JPanel(); //This panel will hold all the containers
    private final JPanel panel2=new JPanel(); //This panel will hold all the radio buttons
    private final JLabel Word_Image= new JLabel("");

    private static final JRadioButton b1 = new JRadioButton("Bottles or Cans");
    private static final JRadioButton b2 = new JRadioButton("E-Waste");
    private static final JRadioButton b3 = new JRadioButton("Mixed Paper");
    private static final JRadioButton b4 = new JRadioButton("Organics");
    private static final JRadioButton b5 = new JRadioButton("Plastics");
    private static final JRadioButton b6 = new JRadioButton("Trash");
    private static final ButtonGroup bg = new ButtonGroup();

    private final Game_Info G1 = new Game_Info();
    private String word;
    private boolean isTimeOn = false;
    private final JLabel image_temp = new JLabel(); // image temp
    private String percentProgress;
    private final Font font = new Font("Papyrus", Font.BOLD,12);

    //Time member variables
    private int elapsedTime = 0;
    private int seconds =0;
    private int minutes =0;
    private int hours =0;
    private String seconds_string = String.format("%02d", seconds);
    private String minutes_string = String.format("%02d", minutes);
    private String hours_string = String.format("%02d", hours);

    public PlayGui() throws IOException {
        setting_containers(); //Setting the containers in the Gui
        setting_Radio_buttons();//Setting the radio buttons in the Gui

        b6.setSelected(true);

        //Exit button to exit the game during the game play
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("src\\main\\java\\cancel-32.jpg");  // An icon for the JOptionPane
                // A JOptionPane should pop up warning the user of their action
                int check = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the current game?" + System.lineSeparator()
                        + "You will lose your progress.", "Exit",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
                if(check == JOptionPane.OK_OPTION){ // if the user decides to exit the game, the application should return to the main screen
                    frame.dispose();
                    GUI g = new GUI();
                    g.run();
                }
            }
        });


        //prev button
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                G1.decrease_counter();
                if(G1.get_Item_type().equals("Words")){ //this is all good
                    display_word_from_database();
                }
                if(G1.get_Item_type().equals("Images")){ // this might need testing
                    display_image_from_database();
                }
                //counter is dealt with but not the score yet
            }
        });


        //this button is good
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Give_userInput_for_ScoreChecking();//Check if user has gotten correct answer
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                G1.increase_counter(); //go to next word
                //System.out.println( G1.get_score());//debugging purposes
                //Checks which item_type has been selected by user
                if(G1.get_Item_type().equals("Words")){ //this is all good
                    display_word_from_database();
                }
                if(G1.get_Item_type().equals("Images")){ // this might need testing
                    display_image_from_database();
                }

            }
        });


        RecycleBin_1.add(panel,BorderLayout.CENTER);
        RecycleBin_1.add(panel2,BorderLayout.SOUTH);
        frame.add(main_panel);
        Path path = Paths.get("src\\main\\java\\GamePlay Info\\Background.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Color bkg = null, thm= null;
        String st;
        while((st= br.readLine())!=null){
            String[] num = st.split("-");
            int r,g,b;
            r= Integer.parseInt(num[0]);
            g= Integer.parseInt(num[1]);
            b= Integer.parseInt(num[2]);
            bkg = new Color(r,g,b);
        }
        br.close();


        Path pathT = Paths.get("src\\main\\java\\GamePlay Info\\Theme.txt");
        String locationT = String.valueOf(pathT.toAbsolutePath()); //holds the image path
        File fileT = new File(locationT);
        BufferedReader brT = new BufferedReader(new FileReader(fileT));
        while((st= brT.readLine())!=null){
            String[] num = st.split("-");
            int r,g,b;
            r=Integer.parseInt(num[0]);
            g= Integer.parseInt(num[1]);
            b= Integer.parseInt(num[2]);
            thm = new Color(r,g,b);
        }
        br.close();


        Font wordFont = new Font("Papyrus",Font.BOLD,48);
        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b6.setFont(font);
        Word_Image.setFont(wordFont);
        main_panel.setBackground(bkg);
        RecycleBin_1.setBackground(bkg);
        word_or_image_panel.setBackground(bkg);
        RecycleBin_1.setBackground(bkg);
        panel.setBackground(bkg);
        panel2.setBackground(bkg);
        nextButton.setBackground(thm);
        prevButton.setBackground(thm);
        pauseButton.setBackground(thm);
        exitButton.setBackground(thm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setVisible(true);
    }

    //help with initialization of either word or image at the start of the game
    public void start_word_or_images(){
        if(G1.get_Item_type().equals("Words")){
            display_word_from_database();
        }
        if(G1.get_Item_type().equals("Images")){
            display_image_from_database();
        }
    }
    //Based on counter in Gameinfo class this word will display the word
    public void display_word_from_database(){
        //first time around
        if(G1.get_counter()== 0){
            word_or_image_panel.add(Word_Image);
            progressLabel.setFont(font);  //At the beginning of the game, show that the progress is 0
            progressLabel.setText("0.0% Done");
        }
        String Game_difficulty_chosen = G1.getGame_Chosen();
        if(Game_difficulty_chosen.equals("Hard")){
            word = G1.get_Hard_database_word(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else if(Game_difficulty_chosen.equals("Normal")){
            word = G1.get_Normal_database_word(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else{ //easy mode
            word = G1.get_Easy_database_word(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        Word_Image.setText(word);
    }

    //Based on counter in Gameinfo class this function will display the image
    public void display_image_from_database(){
        //array of difficulty, pick image depending on the name of those
        //image.jpg
        String Game_difficulty_chosen = G1.getGame_Chosen();
        //word in this case will be a filename to the images
        if(Game_difficulty_chosen.equals("Hard")){
            word = G1.get_Hard_database_image(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else if(Game_difficulty_chosen.equals("Normal")){
            word = G1.get_Normal_database_image(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        else{ //easy mode
            word = G1.get_Easy_database_image(G1.get_counter()); //G1 will store the counter to increment the scores and current position in array
        }
        ImageIcon img1 = resize_containers(word, 400, 250); //img1 will be the image needed
        System.out.println("this is the filename of the images: " +word);
        //first loop around
        if(G1.get_counter() == 0){//starting point
            image_temp.setHorizontalAlignment(SwingConstants.CENTER);
            image_temp.setIcon(img1);
            word_or_image_panel.add(image_temp);
        }
        else{
            image_temp.setIcon(null);
            image_temp.setIcon(img1);
            image_temp.setHorizontalAlignment(SwingConstants.CENTER);
            word_or_image_panel.remove(image_temp);
            word_or_image_panel.add(image_temp);
        }
    }

    //Function to update the game statistics file and Gui
    public void updateGameStats(double number) throws IOException {
        double a = 0,b = 0,c = 0; // These variables will hold the latest, best and worst scores

        Path path = Paths.get("src\\main\\java\\GamePlay Info\\Game Statistics.txt");
        String location = String.valueOf(path.toAbsolutePath()); //holds the image path
        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file)); // reads in the String from the character stream
        String st;

        while((st= br.readLine())!=null){ //read in the line and separate all the scores by a -
            String[] num = st.split("-"); // store them in a, b, c
            a= Double.parseDouble(num[0]);
            b= Double.parseDouble(num[1]);
            c= Double.parseDouble(num[2]);
        }
        br.close();
        String temp = number + "-" + b + "-" + c; // Always update the last played score which is a
        if (a == 0 && b == 0 && c == 0){ // If we are updating the game statistics txt for the first time, set all values to recent score
            temp = number + "-" + number + "-" + number;
        }
        if(number > b && b != 0) { // check if recent score is bigger than the highest score. Update accordingly
            temp = number + "-" + number + "-" + c;
        } else if (number < c && c!= 0){ // check if the recent score is lower than the lowest score. Update accordingly
            temp = number + "-" + b + "-" + number;
        }
        try (BufferedWriter bry = new BufferedWriter(new FileWriter(file))){ // Update the text file
            bry.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Set Score and give to GameInfo Class
    public void Give_userInput_for_ScoreChecking() throws InterruptedException {
        if(b1.isSelected()){
            G1.set_Current_user_word("Bottles/Cans");
        }
        if(b2.isSelected()){
            G1.set_Current_user_word("E-Waste");
        }
        if(b3.isSelected()){
            G1.set_Current_user_word("Mixed Paper");
        }
        if(b4.isSelected()){
            G1.set_Current_user_word("Organic");
        }
        if(b5.isSelected()){
            G1.set_Current_user_word("Plastics");
        }
        if(b6.isSelected()){
            G1.set_Current_user_word("Trash");
        }
        String Game_difficulty_chosen = G1.getGame_Chosen();
        if(Game_difficulty_chosen.equals("Hard")){
            double temp = ((G1.get_counter() + 1)/ Double.valueOf(G1.get_max_number_items())) * 100;
            progressLabel.setText(temp + "% Done");
        }
        else if(Game_difficulty_chosen.equals("Normal")){
            double temp = ((G1.get_counter() + 1)/ Double.valueOf(G1.get_max_number_items())) * 100;
            progressLabel.setText(temp + "% Done");
        }
        else{ //easy mode
            double temp = ((G1.get_counter() + 1)/ Double.valueOf(G1.get_max_number_items())) * 100;
            progressLabel.setText(temp + "% Done");
        }
        G1.check_answer(); //checks the answer and increases score if it is correct
        if(G1.get_counter()==G1.get_max_number_items()-1) { //-1 because it goes from 0 to 14
            if(isTimeOn == true) {
                timerGame.stop();
            }
            double final_score = G1.get_calculated_score();
            System.out.println(final_score);
            try {
                updateGameStats(final_score); // Update the game statistics file and page
            } catch (IOException e) {
                e.printStackTrace();
            }
            nextButton.setText("End"); // change the next button to show that we have reached the end of the game.

            // Shows the progress level during the game play
            progressLabel.setText(String.valueOf(final_score));
            if(final_score == 100.0) { // The user gets a different image and message if they get a perfect score
                Path path = Paths.get("src\\main\\java\\two-happy.jpg");
                String location1 = String.valueOf(path.toAbsolutePath()); //holds the image path
                ImageIcon icon = new ImageIcon(location1);
                int check = JOptionPane.showConfirmDialog(frame, "Congratulations on 100% in " + time.getText() + "." +
                                System.lineSeparator() + "You deserve a cake and medal!!!" +
                                System.lineSeparator() + "Would you like to play again?", "Score",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);

                if(check == JOptionPane.NO_OPTION) { // Go back to the main game screen of they dont want to play again
                    frame.dispose();
                    GUI g = new GUI();
                    g.run();
                } else if(check == JOptionPane.YES_OPTION) { // Go back to the game settings page so that they can choose new options to play again
                    frame.dispose(); // clear out the screen
                    GameSettings g = new GameSettings();
                }
            } else {
                Path path = Paths.get("src\\main\\java\\happy-jumping.jpg");
                String location2 = String.valueOf(path.toAbsolutePath()); //holds the image path
                ImageIcon icon = new ImageIcon(location2); // displays a message to show their final score and time used
                int check = JOptionPane.showConfirmDialog(frame, "Congratulations on " + final_score + "% in " + time.getText() + "." +
                                System.lineSeparator() + "Keep trying for a perfect score!" +
                                System.lineSeparator() + "Would you like to play again?", "Score",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
                if(check == JOptionPane.NO_OPTION) { // Go back to the main game screen if they dont want to paly again
                    frame.dispose();
                    GUI g = new GUI();
                    g.run();
                } else if(check == JOptionPane.YES_OPTION) { // Go back to the game settings page so that they can choose new options to play again
                    frame.dispose(); // clear out the previous screen
                    GameSettings g = new GameSettings();
                }
            }
        }
    }
    //Setting the radio buttons in the Gui
    public void setting_Radio_buttons(){
        panel2.setBounds(20,450,600,300);
        panel2.add(b1);bg.add(b1);
        panel2.add(b2);bg.add(b2);
        panel2.add(b3);bg.add(b3);
        panel2.add(b4);bg.add(b4);
        panel2.add(b5);bg.add(b5);
        panel2.add(b6);bg.add(b6);
    }
    //this function specifies the location of the containers
    public void setting_containers(){
        panel.setBounds(20,350,600,300);
        ImageIcon img1 = resize_containers("src/main/java/Bins/Bottles-Cans.jpg", 100, 100);//
        ImageIcon img2 = resize_containers("src/main/java/Bins/E-Waste.jpg", 100, 100);
        ImageIcon img3 = resize_containers("src/main/java/Bins/Mixed Paper.jpg", 100, 100);
        ImageIcon img4 = resize_containers("src/main/java/Bins/Organics.jpg", 100, 100);
        ImageIcon img5 = resize_containers("src/main/java/Bins/Plastics.jpg", 100, 100);
        ImageIcon img6 = resize_containers("src/main/java/Bins/Trash.jpg", 100, 100);
        panel.add(new JLabel(img1));
        panel.add(new JLabel(img2));
        panel.add(new JLabel(img3));
        panel.add(new JLabel(img4));
        panel.add(new JLabel(img5));
        panel.add(new JLabel(img6));
    }
    //this will resize all the images
    public ImageIcon resize_containers(String filename, int x, int y){
        ImageIcon imageIcon = new ImageIcon(filename); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
    //sends all info from game setting screen to game info class
    public void SetGameGUIParam(String Game_Difficulty, String Game_Item_type , boolean timer, int Game_num_items){
        G1.set_game_all_param(Game_Difficulty, Game_Item_type ,timer, Game_num_items); //give input to this class
        G1.pick_Database_word_array(); //this class will select the array
        if(timer == true){ // check if the user wants to play with the timer
            isTimeOn = true;
            TimerLabel.setFont(font);
            TimerLabel.setText("Timer:"); // display the timer and start it
            timerGame.start();
            pauseButton.addActionListener(new ActionListener() { // if the user decides to pause the game, pause the timer also
                @Override
                public void actionPerformed(ActionEvent e) {
                    timerGame.stop();
                    JOptionPane.showConfirmDialog(frame,"Game Paused. Click Ok to resume.","Pause",JOptionPane.DEFAULT_OPTION);
                    timerGame.start(); // start it up again if they click ok to resume
                }
            });
        }
    }

    //Timer object to set up the timer for the game
    Timer timerGame = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            time.setFont(font);
            elapsedTime=elapsedTime+1000; // the elapsed time keeps updating after each second
            hours = (elapsedTime/3600000);// set up the timer variables
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            time.setText(hours_string+":"+minutes_string+":"+seconds_string);// display the time in format HH:MM:SS
        }
    });
    //Function to reset the timer
    public void reset() {
        timerGame.stop(); //Make sure the timer is not running
        elapsedTime=0; //Set up the variables to 0
        seconds =0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        time.setText(hours_string+":"+minutes_string+":"+seconds_string);// display the reset time in the format HH:MM:SS
    }
    @Override
    public int getScore(){
        return score;
    }
    @Override
    public boolean playAgain(){
        return play_again;
    }
    @Override
    public boolean SaveGame(){
        return save_game;
    }
    public static void main(String[] args) throws IOException {
        PlayGui g = new PlayGui();
    }
}