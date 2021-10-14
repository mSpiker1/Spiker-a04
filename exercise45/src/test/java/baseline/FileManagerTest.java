package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    @Test
    void testList() throws FileNotFoundException {
        //class object to reference FileManager class
        FileManager fm = new FileManager();

        //create a test string arraylist based on the input file for this exercise
        ArrayList<String> test = fm.fileToString("data\\exercise45_input.txt");

        //test cases to ensure the start and end of the arraylist have been read by the method correctly
        assertEquals("One", test.get(0));
        assertEquals("programs\".", test.get(33));
    }

    @Test
    void testReplace(){
        //class object for FileManager
        FileManager fm = new FileManager();

        //create a new arraylist and add a few strings to it
        ArrayList<String> test = new ArrayList<>();
        test.add("test1"); //0
        test.add("test2"); //1
        test.add("test3"); //2
        test.add("test4"); //3
        test.add("test5"); //4

        //use replaceText to replace "test4" with "replaced"
        fm.replaceText(test, "test4", "replaced");

        //test case to see if test4 was properly replaced
        assertEquals("replaced", test.get(3));
    }
}