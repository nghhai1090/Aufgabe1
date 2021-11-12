package service;

import model.FizzBuzz;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzServiceTest {
    private FizzBuzzService fizzBuzzService;
    @BeforeEach
    void setUp() {
        fizzBuzzService = new FizzBuzzService();
    }
    // test if createFizzBuzz work right
    @Test
    void createFizzBuzz() {
        // fizzbuzz object created by methode createFizzBuzz in class FizzBuzzService
        FizzBuzz fizzBuzz = fizzBuzzService.createFizzBuzz(15);
        // fizzbuzz object created by controller in class FizzBuzz
        FizzBuzz fizzBuzzTest = new FizzBuzz(15);
        // get the NumberList of these 2 Objects
        ArrayList fizzBuzzNumberList = fizzBuzz.getNumberList();
        ArrayList fizzBuzzTestNumberList = fizzBuzzTest.getNumberList();
        // test the sizes of these 2 number list
        assertEquals(fizzBuzzTestNumberList,fizzBuzzNumberList);
        // test the elements inside these 2 number list
        for(int i = 0 ; i < fizzBuzzNumberList.size() ; i++){
            assertEquals(fizzBuzzNumberList.get(i),fizzBuzzTestNumberList.get(i));
        }
        // test the output of these 2 fizzbuzz objects
        assertEquals(fizzBuzz.getOutPut(),fizzBuzzTest.getOutPut());
    }
    // test the errorOutput methode if it returns a right map object to transfer into json
    @Test
    void errorOutput() {
        // map created by methode
        Map<String,String> map = fizzBuzzService.errorOutput("500","testing");
        // test the key values paar in map
        assertEquals(map.get("statusCode"),"500");
        assertEquals(map.get("errorDescription"),"testing");
    }
}