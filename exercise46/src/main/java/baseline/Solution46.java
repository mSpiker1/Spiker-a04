/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Matthew Spiker
 */

package baseline;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution46 {
    public static void main(String[] args) throws FileNotFoundException {
        //create class objects for FileManager and Histogram to reference them later
        FileManager fm = new FileManager();
        Histogram h = new Histogram();

        //create constant strings for "badger", "mushroom", and "snake"
        final String b = "badger";
        final String m = "mushroom";
        final String s = "snake";

        //call fileToArray at data\exercise46_input.txt to make a string arraylist "text" of the words in the input file
        ArrayList<String> wordList = fm.fileToArray("data\\exercise46_input.txt");

        /*call wordCounter three times to make three integers "badger", "mushroom", and "snake" with their names as the
        String parameter respectively, and using text as the arraylist parameter*/
        int badger = h.wordCounter(b, wordList);
        int mushroom = h.wordCounter(m, wordList);
        int snake = h.wordCounter(s, wordList);

        //create an empty string array "wordOrder"
        String[] wordOrder = new String[3];

        //gross nested if else statement to sort strings "badger", "mushroom", and "snake" by their corresponding int
        //variable values and store the order in wordOrder
        if(badger>mushroom){
            if(badger>snake){
                wordOrder[0] = b;
                if(mushroom>snake){
                    wordOrder[1] = m;
                    wordOrder[2] = s;
                } else{
                    wordOrder[1] = s;
                    wordOrder[2] = m;
                } //this is so disgusting
            } else if (snake > badger){
                wordOrder[0] = s;
                wordOrder[1] = b;
                wordOrder[2] = m;
            }
        } else if (mushroom > badger){
            if(mushroom > snake){
                wordOrder[0] = m;
                if(badger > snake){
                    wordOrder[1] = b;
                    wordOrder[2] = s;
                } else{
                    wordOrder[1] = s;
                    wordOrder[2] = b;
                } //but it works
            } else if (snake > mushroom){
                wordOrder[0] = s;
                wordOrder[1] = m;
                wordOrder[2] = b;
            }
        }

        //create an integer array "numWords" of the three integer variables and sort it from highest to lowest
        Integer[] numWords = {badger, mushroom, snake};
        Arrays.sort(numWords, Collections.reverseOrder());

        //call histPrint with numWords and wordOrder as parameters
        h.histPrint(numWords, wordOrder);
    }
}

class FileManager{
    //method to create a string array from an input file
    //I know sonarlint doesn't like this filePath variable, but it makes it easier to reuse this method later on by doing this
    ArrayList<String> fileToArray(String filePath) throws FileNotFoundException {
        //create an empty String arraylist "list"
        ArrayList<String> list = new ArrayList<>();

        //create a new File object "inputFile" at filePath
        File inputFile = new File(filePath);

        //open try statement to avoid exceptions and create a file scanner for inputFile
        try (Scanner inFile = new Scanner(inputFile)) {
            //open while loop to loop while the scanner finds text as it moves through the lines
            while (inFile.hasNext()) {
                //initialize a String "tempText" that is assigned the current line's text
                String tempText = inFile.next();

                //add tempText to the arraylist
                list.add(tempText);
            }
        }
        //return the arraylist list
        return list;
    }
}

class Histogram{
    int wordCounter(String search, ArrayList<String> wordList){
        //create an integer wordCounter equal to 0
        int wordCounter = 0;

        //create a for loop [for(int i=0; i<wordList.size(); i++)] (loops wordList.size() times)
        for (String s : wordList) {
            //create if statement to test if the current string in wordlist contains the search string
            if (s.equals(search)) {
                //add 1 to the wordCounter
                wordCounter++;
            }
        }

        //return wordCounter
        return wordCounter;
    }

    void histPrint(Integer[] numWords, String[] wordOrder){
        //create for loop [for(int i=0; i<numWords[].length(); i++)] (loops numWords.length() times)
        for(int i=0; i<numWords.length; i++) {
            //print wordOrder[i] + ": " (name of current word and a colon)
            System.out.print("\n" + wordOrder[i] + ":  \t");
            //create a nested for loop for[(int i=0; i<numWords[i]; i++)] (loops numWords[i] times)
            for(int j=0; j<numWords[i]; j++) {
                //print "*"
                System.out.print("*");
            }
        }
        //prints a newline just to separate direct program output from other terminal output
        System.out.print("\n");
    }
}
