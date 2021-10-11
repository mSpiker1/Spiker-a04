package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void employeeTest(){
        //class object for Employee
        Employee emp = new Employee();

        //create test string equal to the final string returned by printEmployees
        String test = emp.printEmployees("data\\exercise42_input.txt");

        /* test if the string is equivalent to the expected value if the while loop in the method executed correctly
        if it did, it should return the last line of the input file, which is "Zarnecki,Sabrina,51500" */
        boolean testTrue = test.equals("Zarnecki,Sabrina,51500");
        assertTrue(testTrue);
    }
}