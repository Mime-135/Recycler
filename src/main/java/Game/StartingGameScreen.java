package Game;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;


public class StartingGameScreen {
    private final JFrame frame = new JFrame("Game Settings");
    private final JPanel panel=new JPanel(); //This panel will hold the difficulty
    private final JPanel panel2=new JPanel(); //This panel will hold the items
    private final JPanel panel3=new JPanel(); //This panel will hold the items
    private final JPanel panel4=new JPanel(); //This panel will hold the items
    private final JPanel panel5 =new JPanel(); //This panel will hold the theme
    private final JPanel panel6 =new JPanel(); //This panel will hold the num of items

    private final JLabel Setdifficulty =new JLabel("Choose Difficulty"); //This label will hold the items
    private final JLabel SetWordorImages =new JLabel("Choose Word Or Image"); //This label will hold the items
    private final JLabel Timer =new JLabel("Select for Timer"); //This label will hold the items
    private final JLabel Theme =new JLabel("Choose For Theme"); //This label will hold the items
    private final JLabel Num_of_items =new JLabel("Choose Number of Words/Images"); //This label will hold the items

    private final JRadioButton r1 = new JRadioButton("Easy"); //Easy
    private final JRadioButton r2 = new JRadioButton("Normal"); //Normal
    private final JRadioButton r3 = new JRadioButton("Hard"); //Hard
    private final ButtonGroup bg_Difficulty = new ButtonGroup();
    // Need to make button group
    private final JRadioButton r4 = new JRadioButton("Images"); // Images
    private final JRadioButton r5 = new JRadioButton("Words"); // Words
    private final ButtonGroup bg_item_type = new ButtonGroup();
    // Need to make button group again

    private final JRadioButton r6 = new JRadioButton(); // For timer
    private final ButtonGroup bg_Timer = new ButtonGroup();

    private final JRadioButton r7 = new JRadioButton("Household items"); // For theme household
    private final JRadioButton r8 = new JRadioButton("Forest"); // For theme forest
    private final JRadioButton r9 = new JRadioButton("Beach"); // For theme beach items
    private final ButtonGroup bg_theme = new ButtonGroup();

    private final JRadioButton r10 = new JRadioButton("5"); // For theme household
    private final JRadioButton r11 = new JRadioButton("10"); // For theme forest
    private final JRadioButton r12 = new JRadioButton("15"); // For theme beach items
    private final ButtonGroup bg_numItems = new ButtonGroup();



    private final JButton b1 = new JButton("Start Game");

    public void StartingGameScreen(){
    }


    public void run()
    {
        //frame.setLayout(null); // frame
       // panel.setLayout(new GridLayout(3, 5));
        panel.add(Setdifficulty);
        panel.add(r1);bg_Difficulty.add(r1);
        panel.add(r2);bg_Difficulty.add(r2);
        panel.add(r3);bg_Difficulty.add(r3);
        panel2.add(SetWordorImages);
        panel2.add(r4);bg_item_type.add(r4);
        panel2.add(r5);bg_item_type.add(r5);
        panel3.add(Timer);
        panel3.add(r6);bg_Timer.add(r6);
        panel4.add(b1);
        panel5.add(Theme);
        panel5.add(r7); bg_theme.add(r7);
        panel5.add(r8);bg_theme.add(r8);
        panel5.add(r9);bg_theme.add(r9);
        panel6.add(Num_of_items);
        panel6.add(r10);bg_numItems.add(r10);
        panel6.add(r11);bg_numItems.add(r11);
        panel6.add(r12);bg_numItems.add(r12);


        //When b1 button is clicked
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                //get all the info from the button groups
                //theme g
                String Game_Theme = get_Theme();
                //difficultly
                String Game_Difficulty = get_Difficulty();
                // item_type
                String Game_Item_type = get_Item_type();
                //timers
                boolean timer = get_Timer(); //true if it is selected
                //num of items
                int Game_num_items = get_Item_num();

                Game_Info G1 = new Game_Info();


                G1.set_game_all_param(Game_Difficulty, Game_Item_type ,timer, Game_num_items);
                GAME_GUI G = new GAME_GUI();
            }
        });

        panel.setBounds(150,50,300,100);
        panel2.setBounds(150,150,200,100);
        panel3.setBounds(150,250,200,100);
        panel4.setBounds(150,350,200,100);
        panel5.setBounds(150,450,200,100);
        //panel5.setBounds(150,550,200,100);

        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);



        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);

    }

    //////////////////////////////////////////GETTERS//////////////////////////////////////////////////////////
    //Theme getter
    public String get_Theme(){
        if(r7.isSelected()){
            return "Household";
        }
        else if(r8.isSelected()){
            return "Forest";
        }
        else{
            return "Beach";
        }
    }
    //getter for difficulty
    public String get_Difficulty(){
        if(r1.isSelected()){
            return "Easy";
        }
        else if(r2.isSelected()){
            return "Normal";
        }
        else{
            return "Hard";
        }
    }
    //getter for item type
    public String get_Item_type(){
        if(r4.isSelected()){
            return "Images";
        }
        else {
           return "Words";
        }
    }
    //getter for item numbers
    public int get_Item_num(){
        if(r10.isSelected()){
            return 5;
        }
        else if(r11.isSelected()){
            return 10;
        }
        else{
            return 15;
        }
    }


    public boolean get_Timer(){
        return r6.isSelected();
    }



    public static void main(String[] args) {
        StartingGameScreen g = new StartingGameScreen();
        g.run();


    }
}
