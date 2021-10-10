/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Matthew Spiker
 */

package baseline;
import java.util.ArrayList;
import java.util.List;

public class Solution41 {
    public static void main(String args[]) {
        //create scanner object to read a file

        //create an array to store the list of names

        //call readToList function from nameManager to read the input file to an arrayList of strings

        //sort the current arrayList using sort function

        //close input scanner object

        //call writeNames function to create and write the output file from the now sorted arrayList
    }
}

//class containing the functions to manage and sort the list of names
class nameManager {
    //function to read through and add lines from input file to an arrayList
    public void readToList(ArrayList<String>nameList){
        //while loop to loop through lines in the file until there is nothing on the next line
        //add the current line to the arrayList every loop
    }

    //function to write output file using sorted list of names
    public void writeNames(ArrayList<String>sortedNames){
        //create a file writer to write the output file

        //write the file header that precedes the sorted list of names
        //"Total of numNames names\n-----------------"

        //for loop to loop through each line until numNames has been reached
        //output the current line each loop

        //close the output file (don't want memory leaks)
    }
}