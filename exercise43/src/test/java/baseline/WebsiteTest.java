package baseline;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteTest {
    @Test
    //tests createPath method
    void testCreate(){
        //class reference object for Website()
        Website web = new Website();

        //create File object with the address of a test folder to be created (called "test")
        File testPath = new File("test\\");

        //create string with the address of the test folder written to it
        String filePath = "test\\";

        //create a boolean value to be used as a testing variable, defaulted to false
        boolean testValue = false;

        //run the createPath method and set testValue to what it returns (should return true if it is successful)
        testValue = web.createPath(filePath);

        //delete the test folder directory
        testPath.delete();

        //test if the testValue variable has been set to true, as expected
        assertTrue(testValue);
    }

    @Test
    void testFile() throws IOException {
        //class reference object for Website
        Website web = new Website();

        //create file objects for test directory and the html file to be created
        File path = new File("testHTML\\");
        File htmlPath = new File("testHTML\\index.html");

        //create string with test directory address written to it
        String filePath = "testHTML\\";

        //creates the test directory
        path.mkdir();

        //creates the HTML file inside the test directory using the createFile method
        web.createFile("Name", "Author", filePath);

        //create expected String values of lines 2 and 5 of the html file that was created by createFile()
        String expected2 = "<meta name = \"author\" content = \"Author\">";
        String expected5 = "Name";

        //create Strings equal to the values found on lines 2 and 5 of the html file
        String line2 = Files.readAllLines(Paths.get("testHTML\\index.html")).get(2);
        String line5 = Files.readAllLines(Paths.get("testHTML\\index.html")).get(5);

        //deletes the test directory
        htmlPath.delete();
        path.delete();

        assertEquals(line2, expected2);
        assertEquals(line5, expected5);
    }
}