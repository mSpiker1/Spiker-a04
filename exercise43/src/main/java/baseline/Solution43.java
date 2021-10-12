/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */

package baseline;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution43 {
    //main method
    public static void main(String[] args) throws IOException {
        //create class object web to reference class Website
        Website web = new Website();

        //create keyboard input scanner, initialize variables for user input and a file for base directory
        Scanner input = new Scanner(System.in);
        final String siteDir = "data\\website\\";
        File webDir = new File("data\\website\\");

        //ask for website name and assign it to a variable siteName
        System.out.print("Site name: ");
        String siteName = input.nextLine();

        //ask for author name and assign it to a variable author
        System.out.print("Author: ");
        String author = input.nextLine();

        //ask if the user wants a folder for JavaScript and assign the answer to String jsyn
        System.out.print("Do you want a folder for JavaScript? ");
        String jsyn = input.nextLine();

        //ask if the user wants a folder for CSS and assign answer to cssyn
        System.out.print("Do you want a folder for CSS? ");
        String cssyn = input.nextLine();

        /*    -create a directory for the website using the File webDir created earlier-
        I don't know why there is a SonarLint warning here. It says the operation is ignored, but it successfully
        creates the directory I need when it runs, and the program breaks without it. I've chosen to ignore it and
        assume that there's either a better way to do this that I don't know about or SonarLint is just being stupid.
         */
        webDir.mkdir();

        //call createPath to create a path to data/website/siteName
        boolean baseTest = web.createPath(siteDir + siteName + "\\");

        //if statement to continue the rest of the program if the first directory was created successfully
        if(baseTest){

            //call createFile to create an HTML file named index.html using siteName and author for components
            web.createFile(siteName, author, siteDir + siteName);

            //if jsyn = y || Y
            if (jsyn.equals("y") || jsyn.equals("Y")) {
                //call createPath to create a path at data/website/siteName/js/
                web.createPath(siteDir + siteName + "\\js\\");
            }

            //if cssyn = y || Y
            if (cssyn.equals("y") || cssyn.equals("Y")) {
                //call createPath to create a path at data/website/siteName/css/
                web.createPath(siteDir + siteName + "\\css\\");
            }
        }else{
            //prints this to console if the first directory was not successfully created
            System.out.print("The directory could not be created.");
        }
    }
}

//class to handle creation/adjustment of website files/directories
class Website{
    //method to create a directory at filePath
    boolean createPath(String filePath){
        //initialize File variable "directory" at filePath, also initialize boolean variable to return for a unit test
        File directory = new File(filePath);
        boolean success;

        //create the directory at filePath using mkdir method, also set success to true if the creation was successful
        success = directory.mkdir();

        //output "created [directory]"
        System.out.printf("Created %s%n", filePath);

        //return the value of success
        return success;
    }

    //method to create an HTML file at filePath
    void createFile(String siteName, String author, String filePath) throws IOException {
        //create fileWriter "index" at filePath
        try (FileWriter htmlWriter = new FileWriter(filePath + "\\index.html")) {

            //sequence to write html file:
            htmlWriter.write("<html>\n<head>\n");
            htmlWriter.write("<meta name = \"author\" content = \"" + author + "\">"); //write the author name in a meta tag
            htmlWriter.write("\n</head>\n<title>\n");
            htmlWriter.write(siteName); //write the site name in the title tag
            htmlWriter.write("\n</title>\n<body>");
        }

        //output "created [filedir]"
        System.out.printf("created %s\\index.html%n", filePath);
    }
}