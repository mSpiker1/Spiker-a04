/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 first_name last_name
 */

package baseline;
import java.nio.file.Path;

public class Solution43 {
    //main method
    public static void main(String[] args){
        //create keyboard input scanner, initialize variables for user input

        //ask for website name and assign it to a variable siteName

        //ask for author name and assign it to a variable author

        //ask if the user wants a folder for JavaScript and assign the answer to String jsyn

        //ask if the user wants a folder for CSS and assign answer to cssyn

        //call createPath to create a path to data/website/siteName

        //call createFile to create an HTML file named index.html using siteName and author for components

        //if jsyn = y || Y
            //call createPath to create a path at data/website/siteName/js/

        //if cssyn = y || Y
            //call createPath to create a path at data/website/siteName/css/
    }
}

//class to handle creation/adjustment of website files/directories
class Website{
    //method to create a directory at filePath
    void createPath(String filePath){
        //initialize File variable "directory" at filePath

        //create the directory at filePath using mkdir method

        //output "created [directory]"
    }

    //method to create an HTML file at filePath
    void createFile(String siteName, String author, String filePath){
        //create fileWriter "index" at filePath

        //sequence to write html file:
        //write <html>
        //write <head>
        //write <meta name = "author" content = "%s">, author
        //write </head>
        //write <title>
        //write siteName
        //write </title>
        //write <body>

        //output "created [filedir]"
    }
}