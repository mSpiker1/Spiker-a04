/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Matthew Spiker
 */

package baseline;
import java.io.*;


public class Solution44{
    //main method to call other methods to operate the program
    public static void main(String[] args) throws IOException {
        //initialize class reference object for JsonReader and ProductManager

        //Create a new Products object "prod" from calling readJson method

        //call nameSearch with parameter prod
    }
}

//class to store product information
class ProdBase{
    //initialize a string for name, a double for price, and an integer for quantity
}

//class to store information for multiple products in an array
//this class represents objects equivalent to those found in the input json file
class Products {
    //create an array of ProdBase objects called "products"
}

//class to read from json files
class JsonReader{
    Products readJson() throws IOException {
        //create a gson object

        //create a reader object to read in the json file at data\exercise44_input.json

        //create a new Products object "p" from the object in the json file

        //return p to where the method was called
        return null;
    }
}

//class to manage Product objects
class ProductManager{
    void nameSearch(Products p){
        //create a user input scanner

        //create a boolean variable "loop" and set it to true

        //open a while loop for while loop is false [while(loop)]
            //prompt for user input "What was the product name? "
            //store the user's input in String "search"
            //open for loop to loop through p.products.length times [for(int i=0; i<p.products.length; i++)]
                //open if statement to match p.products[i] to search [if(p.products[i].equals(search))]
                    //output all of p.products[i] parameters ("Name: " + p.products[i].name + "\n", and so on)
                    //set loop to false
    }
}