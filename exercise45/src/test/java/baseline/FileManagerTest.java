package baseline;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    //test case for fileToString()
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

    //test case for replaceText()
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

    //test case for writeOut
    @Test
    void testWrite() throws IOException {
        //class object for FileManager
        FileManager fm = new FileManager();

        //File and String objects for test output paths
        File path = new File("test\\");
        File txt = new File("test\\testOut.txt");
        String txtPath = "test\\testOut.txt";

        //create arraylist to write to the file
        ArrayList<String> writeThis = new ArrayList<>();
        writeThis.add("Once");
        writeThis.add("\nupon");
        writeThis.add("\na");
        writeThis.add("\ntime...");

        //create the test\\ directory
        //made this boolean just to make SonarLint shut up about not using the bool value from mkdir
        boolean dirMake = path.mkdir();

        //call the writeOut method to write the arraylist to a file under \test\testOut.txt
        fm.writeOut(txtPath, writeThis);

        //Create two strings read from the test file to ensure it was written properly (beginning and end of file)
        String first = Files.readAllLines(Paths.get("test\\testOut.txt")).get(0);
        String last = Files.readAllLines(Paths.get("test\\testOut.txt")).get(3);

        //delete the test directory
        dirMake = txt.delete();
        dirMake = path.delete();

        //test cases to see if the strings match their expected values and to ensure the directory was created properly
        assertEquals("Once ", first);
        assertEquals("time... ", last);
        assertTrue(dirMake);
    }
}