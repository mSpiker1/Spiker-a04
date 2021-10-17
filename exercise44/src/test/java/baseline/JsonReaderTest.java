package baseline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    //test for readJson()
    @Test
    void testReader() throws IOException {
        //class object for JsonReader
        JsonReader j = new JsonReader();

        //make a new Product object by calling readJson and using the exercise file for the assignment
        Product p = j.readJson("data\\exercise44_input.json");

        //test to see if certain parameters of the Product object "p" are as expected
        //is p[0]'s name Widget?
        assertEquals("Widget", p.products[0].name);
        //is p[2]'s price 5.00?
        assertEquals(5.00, p.products[2].price);
        //is p[1]'s quantity 5?
        assertEquals(5, p.products[1].quantity);
    }

    //test for nameSearch
    @Test
    void testSearch() throws IOException {
        //class objects for ProductManager and JsonReader
        JsonReader j = new JsonReader();
        ProductManager pm = new ProductManager();

        //create a scanner object to pass a String (rather than actual user input) to nameSearch
        Scanner in = new Scanner("Thing");

        //call JsonReader to create a product object to search through with nameSearch
        Product prod = j.readJson("data\\exercise44_input.json");

        //call nameSearch to search, should return true to a boolean variable "test"
        boolean test = pm.nameSearch(prod, in);

        //test if test is true
        assertTrue(test);
    }
}