package baseline;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HistogramTest {
    //test for wordCounter
    @Test
    void testWordCounter(){
        //class object for Histogram
        Histogram h = new Histogram();

        //create a String arraylist to use on wordCounter
        ArrayList<String> testArr = new ArrayList<>();
        testArr.add("true");
        testArr.add("true");
        testArr.add("false");
        testArr.add("false");
        testArr.add("true");

        int numTrue = h.wordCounter("true", testArr);

        assertEquals(3, numTrue);
    }
    //test for histPrint
    @Test
    void testHistPrint(){
        //class object for Histogram
        Histogram h = new Histogram();

        //create a String array wordOrder for the order of the words
        String[] wordOrder = {"word1", "word2", "word3"};

        //create an Integer array of a number of words
        Integer[] numWords = {1, 3, 5};

        //call histPrint with numWords and wordOrder as parameters
        h.histPrint(numWords, wordOrder);
    }
    //test for fileToArray
    @Test
    void testToArray() throws FileNotFoundException {
        //class object to reference FileManager class
        FileManager fm = new FileManager();

        //create a test string arraylist based on the input file for this exercise
        ArrayList<String> test = fm.fileToArray("data\\exercise46_input.txt");

        //test cases to ensure the start and end of the arraylist have been read by the method correctly
        assertEquals("badger", test.get(0));
        assertEquals("mushroom", test.get(4));
    }
}