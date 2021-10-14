/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Matthew Spiker
 */

package baseline;
import java.util.ArrayList;

public class Solution46 {
    public static void main(String[] args){
        //create class objects for FileManager and Histogram to reference them later

        //call fileToArray at data\exercise46_input.txt to make a string arraylist "text" of the words in the input file

        /*call wordCounter three times to make three integers "badger", "mushroom", and "snake" with their names as the
        String parameter respectively, and using text as the arraylist parameter*/

        //create an empty string array "wordOrder"

        //gross nested if else statement to sort strings "badger", "mushroom", and "snake" by their corresponding int
        //variable values and store the order in wordOrder

        //create an integer array "numWords" of the three integer variables and sort it from highest to lowest

        //call histPrint with numWords and wordOrder as parameters
    }
}

class FileManager{
    ArrayList<String> fileToArray(String filePath){
        //create an empty string arraylist "list"

        //create a new File object "inputFile" at filePath

        //open try statement to avoid exceptions and create a file scanner for inputFile
            //open while loop to loop while the scanner finds text as it moves through the lines
                //initialize a String "tempText" that is assigned the current line's text

                //add tempText to the arrayList

        //return the arraylist "list"
        return null;
    }
}

class Histogram{
    int wordCounter(String search, ArrayList<String> wordList){
        //create an integer wordCounter equal to 0

        //create a for loop [for(int i=0; i<wordList.size(); i++)] (loops wordList.size() times)
            //create if statement to test if the current string in wordlist contains the search string
                //add 1 to the wordCounter

        //return wordCounter
        return 0;
    }

    void histPrint(Integer[] numWords, String[] wordOrder){
        //create for loop [for(int i=0; i<numWords[].length(); i++)] (loops numWords.length() times)
            //print wordOrder[i] + ": " (name of current word and a colon)
            //create a nested for loop for[(int i=0; i<numWords[i]; i++)] (loops numWords[i] times)
                //print "*"
    }
}
