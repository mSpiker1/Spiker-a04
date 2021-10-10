package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class NameManagerTest {
    @Test
    void fileTest() throws FileNotFoundException {
        //create class object to reference NameManager
        NameManager nm = new NameManager();

        //create arraylist
        ArrayList<String> list = new ArrayList<>();

        //creates scanner for file
        Scanner fileInput = new Scanner(new File("data\\exercise41_input.txt"));

        //calls readToList function to write specified file to the arraylist
        nm.readToList(fileInput, list);

        //sets a test string equal to the first string in the arraylist
        String test = list.get(0);

        //create boolean value based on if the first string in the arraylist is "Ling, Mai"
        boolean testBool = test.equals("Ling, Mai");

        //if the testBool value is true (first string in arraylist is as expected), the test case passes
        assertTrue(testBool);
    }
}