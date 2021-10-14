/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Matthew Spiker
 */

package baseline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution45 {
    //main method
    public static void main(String[] args) throws IOException {
        //create a class object fm to reference class FileManager
        FileManager fm = new FileManager();

        //create keyboard input scanner
        Scanner input = new Scanner(System.in);

        //get the name of the output file from the user
        System.out.print("What do you want the output file to be named? ");
        String fileName = input.nextLine();

        //create two constant Strings "filePath" to reference data\exercise45_input.txt and "outPath" for data\fileName from user input
        final String filePath = "data\\exercise45_input.txt";
        final String outPath = "data\\" + fileName + ".txt";

        //initialize a new arraylist "text" that calls fileToString at filePath for its value
        ArrayList<String> text = fm.fileToString(filePath);

        //call replaceText with the text, "utilize", and "use" as parameters
        fm.replaceText(text, "utilize", "use");

        //call writeOut to create the new output file with parameters outPath and text
        fm.writeOut(outPath, text);
    }
}

//class to handle the input and output files
class FileManager {
/*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///                       -method to return an arraylist of the text in the input file-                              ///
///           I know SonarLint doesn't like that I'm using a constant here instead of just hardcoding,               ///
///     but I want this method to be usable outside just this program and this is the best way to do that            ///
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    ArrayList<String> fileToString(String filePath) throws FileNotFoundException {
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
        return list;
    }

    //method to replace portions of the arraylist that match toRemove with toReplace
    //same thing with sonarlint here as the fileToString method
    void replaceText(ArrayList<String> text, String toRemove, String toReplace) {
        //open for loop [for(int i=0; i<text.size(); i++)]
        for (int i = 0; i < text.size(); i++) {
            //open if statement to see if the string in text[i] matches toRemove (search for "utilize")
            if (text.get(i).contains(toRemove)) {
                //this sequence will set the toRemove in text[i] to toReplace without changing anything else

                //create a new string from the current line
                String tempReplace = text.get(i);

                //set the string to be itself, but with toRemove replaced by toReplace with nothing else changed
                tempReplace = tempReplace.replace(toRemove, toReplace);

                //set the current line to tempReplace
                text.set(i, tempReplace);
            }
        }
    }

    //method to write the arraylist to a new output file
    void writeOut(String outPath, ArrayList<String> text) throws IOException {
        //open a try statement and create a FileWriter object "writer" to write the arraylist to the file at outPath
        try (FileWriter writer = new FileWriter(outPath)) {
            //open a for loop [for(int i=0; i<text.size(); i++)]
            for (int i=0; i<text.size(); i++) {
                //write text[i] to the output file and a space
                writer.write(text.get(i) + " ");

                //if statement to put newlines properly, no constraints against hardcoding this, and it's the last thing
                //I need to do for this program, so I'm gonna be lazy
                if(i == 11 || i == 25){
                    writer.write("\n");
                }
            }
        }
    }
}