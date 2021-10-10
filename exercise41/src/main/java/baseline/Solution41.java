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
import java.util.List;
import java.util.Scanner;

public class Solution41 {
    public static void main(String[] args) throws FileNotFoundException {
        //create new object to reference class NameManager
        NameManager nm = new NameManager();

        //create scanner object to read a file
        Scanner inputFile = new Scanner(new File("data\\exercise41_input.txt"));

        //create an array to store the list of names
        ArrayList<String> nameList = new ArrayList<>();

        //call readToList function from nameManager to read the input file to an arrayList of strings
        nm.readToList(inputFile, nameList);

        //sort the current arrayList using sort function
        nameList.sort(String.CASE_INSENSITIVE_ORDER);

        //close input scanner object
        inputFile.close();

        //call writeNames function to create and write the output file from the now sorted arrayList
        //user try/catch to catch any file not found exception and output to console
        try{
            nm.writeNames(nameList);
        }
        catch(Exception e){
            System.out.print("Error: File not found");
        }
    }
}

//class containing the functions to manage and sort the list of names
class NameManager {

    //function to read through and add lines from input file to an arrayList
    public void readToList(Scanner input, List<String> nameList){
        //while loop to loop through lines in the file until there is nothing on the next line
        while(input.hasNextLine()) {
            //add the current line to the arrayList every loop
            nameList.add(input.nextLine());
        }
    }

    //function to write output file using sorted list of names
    public void writeNames(List<String>sortedNames) throws IOException {
        //create a file writer to write the output file
        try (FileWriter writeNames = new FileWriter("data\\exercise41_output.txt")) {

            //write the file header that precedes the sorted list of names
            //"Total of numNames names\n-----------------"
            writeNames.write("Total of " + sortedNames.size() + " names\n");
            writeNames.write("-".repeat(17) + "\n");

            //for loop to loop through each line until numNames has been reached
            //output the current line each loop
            for (String i : sortedNames) {
                writeNames.write(i + "\n");
            }

            //close the output file (don't want memory leaks)
        }
    }
}