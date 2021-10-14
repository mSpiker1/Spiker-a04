package baseline;

import java.util.ArrayList;

public class Solution45 {
    //main method
    public static void main(String[] args){
        //create a class object fm to reference class FileManager

        //create two constant Strings "filePath" to reference data\exercise45_input.txt and "outPath" for data\exercise45_output.txt

        //initialize a new arraylist "text" that calls fileToString at filePath for its value

        //call replaceText with the text, "utilize", and "use" as parameters

        //call writeOut to create the new output file with parameters outPath and text
    }
}

//class to handle the input and output files
class FileManager{
    //method to return an arraylist of the text in the input file
    void fileToString(String filePath){
        //create an empty String arraylist "list"

        //create a new File object "inputFile" at filePath

        //create a new Scanner object for inputFile

        //open try statement to avoid exceptions
            //open while loop to loop while the scanner finds text as it moves through the lines
                //initialize a String "tempText" that is assigned the current line's text

                //add tempText to the arraylist
        //close try statement and open finally statement
            //close the scanner object to avoid memory leaks
    }

    //method to replace portions of the arraylist that match toRemove with toReplace
    void replaceText(ArrayList<String> text, String toRemove, String toReplace){
        //open for loop [for(int i=0; i<text.size(); i++)]
            //open if statement to see if the string in text[i] matches toRemove
                //set text[i] to toReplace
    }

    //method to write the arraylist to a new output file
    void writeOut(String outPath, ArrayList<String> text){
        //create a FileWriter object "writer" to write the arraylist to the file at outPath

        //open a try statement
            //open a for loop [for(int i=0; i<text.size(); i++)]
                //write text[i] to the output file and a space
        //close try statement and open finally
            //close writer object
    }
}