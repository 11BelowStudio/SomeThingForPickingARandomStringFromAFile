package Packij;

//pretty much reverse-engineered from my HighScoreHandler stuff in some of my other games

//https://github.com/IDontHaveAnyClueWhatToPutHere/SomeThingForPickingARandomStringFromAFile git repo ayy lmao

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class RandomStringChooser {

    private ArrayList<String> strings; //holds the strings what are being randomized

    private final String fileLocation = "fileGoesHere/random.txt"; //location of the random word file


    public static void main(String args[]) {

        System.out.println("** RANDOM STRING CHOOSER THING **");
        System.out.println("\nmade for a game jam I was helping to run in march 2020 (idk if it was used or not lmao)");

        System.out.println("make sure you put your strings in the 'fileGoesHere/random.txt' file pls\n");

        int rerollCount = 0;


        RandomStringChooser rsc = new RandomStringChooser(); //basically reading the stuff now
        boolean quit = false;
        do{
            switch(rerollCount) {
                case 0:
                    break;
                case 1:
                    System.out.println("aight so time to try again");
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    System.out.println("bruh you've done this "+ rerollCount + " times already smh my head");
                    break;
                default:
                    System.out.println("pretty disappointed in you ngl");
            }
            System.out.println("The result is...");

            rsc.roll();
            System.out.println("\nenter 'r' if you want to reroll (pls dont though), anything else to quit");
            String userChoice = rsc.getLine();
            if (!userChoice.equals("r")){
                quit = true; //will not reroll if you entered r
            } else{
                //will reroll if you do enter r
                if(rerollCount > 5){
                    System.out.println(">:(\n");
                } else {
                    System.out.println("smh my head okay then\n");
                }
                rerollCount++;
            }
        } while(!quit);
        System.out.println("aight bye");
        //bye
    }

    RandomStringChooser() {



        strings = new ArrayList<>(); //initialises the string arrayList



        String currentReadString;
        //currently read string is stored here


        //will now attempt to read the high score file and add the string to the list of strings
        try {
            FileReader fr = new FileReader(fileLocation);
            BufferedReader br = new BufferedReader(fr);
            //pretty much setting up the stuff for reading the file

            //until the end of the file is reached/line is null, it will add something to strings for everything in that file
            while ((currentReadString = br.readLine()) != null) {
                strings.add(currentReadString);
            }
            br.close(); //closes the bufferedReader


        } catch (FileNotFoundException e) {
            //if the file couldn't be found
            System.out.println("did u delete the random words file? smh my head");
            //records and complains about lack of file


        } catch (Exception ex) {
            System.out.println("yeah something weird happened");
            ex.printStackTrace();
            //covers anything else that may be thrown
        }



    }

    void roll() {
        if (!strings.isEmpty()) {
            Collections.shuffle(strings);
            //ensures that the strings are randomized
            System.out.println(strings.get(0));
            //outputs the random string
        } else{
            System.out.println("bruh there's no strings to choose from smh my head");
        }
    }

    String getLine() {
        //just obtains a user input basically
        String line= "";
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = buf.readLine().trim();

        } catch (Exception e) {
            System.out.println("Unexpected error in input");
            System.exit(1);
        }
        return(line);
    }



}