/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Matthew Spiker
 */

package baseline;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Solution44{
    //main method to call other methods to operate the program
    public static void main(String[] args) throws IOException {
        //initialize class reference object for JsonReader and ProductManager
        JsonReader j = new JsonReader();
        ProductManager pm = new ProductManager();

        //Create a new Products object "prod" from calling readJson method
        Product prod = j.readJson("data\\exercise44_input.json");

        //create an input scanner to pass to nameSearch
        Scanner input = new Scanner(System.in);

        //call nameSearch with parameter prod
        pm.nameSearch(prod, input);
    }
}

//class to store product information
class ProdBase{
    //initialize a string for name, a double for price, and an integer for quantity
    String name;
    double price;
    int quantity;
}

//class to store information for multiple products in an array
//this class represents objects equivalent to those found in the input json file
class Product {
    //create an array of ProdBase objects called "products"
    ProdBase[] products;
}

//class to read from json files
class JsonReader{
    //SonarLint doesn't like this, but it's better for reusable code to have a string variable instead of the direct path
    Product readJson(String filePath) throws IOException {
        //create a gson object
        Gson g = new Gson();

        //create a reader object to read in the json file at data\exercise44_input.json
        Reader reader = Files.newBufferedReader(Paths.get(filePath));

        //return a Products object created from the gson + reader objects
        return g.fromJson(reader, Product.class);
    }
}

//class to manage Product objects
class ProductManager{
    boolean nameSearch(Product p, Scanner input){
        //create a decimal formatter for pricing
        DecimalFormat pricing = new DecimalFormat("0.00");

        //open a while loop for while loop is false [while(loop)]
        while(true) {
            //prompt for user input "What was the product name? "
            System.out.print("What was the product name? ");

            //store the user's input in String "search"
            String search = input.nextLine();

            //open for loop to loop through p.products.length times [for(int i=0; i<p.products.length; i++)]
            for(int i=0; i<p.products.length; i++) {
                //open if statement to match p.products[i] to search [if(p.products[i].name.equals(search))]
                if(p.products[i].name.equals(search)) {
                    //output all of p.products[i] parameters ("Name: " + p.products[i].name + "\n", and so on)
                    System.out.print("Name: " + p.products[i].name + "\n");
                    System.out.print("Price: " + pricing.format(p.products[i].price) + "\n");
                    System.out.print("Quantity: " + p.products[i].quantity);

                    //return true to break the loop and close the method
                    return true;
                }
            }
            //outputs error message if a product matching the search string was not found
                System.out.print("Sorry, that product was not found in our inventory.\n");
        }
    }
}