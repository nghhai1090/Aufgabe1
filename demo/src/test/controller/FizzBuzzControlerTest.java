package controller;

import model.FizzBuzz;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzControlerTest {
    private FizzBuzzControler fizzBuzzControler;
    @BeforeEach
    void setUp() {
        fizzBuzzControler = new FizzBuzzControler();
    }
    // test fizzbuzz methode with parameter 15.
    @Test
    void fizzBuzz() {
        // fizzbuzz object created by methode fizzBuzz in class fizzbuzzcontroller
        FizzBuzz fizzBuzz = fizzBuzzControler.fizzBuzz("15");
        // fizzbuzz object created by controller in class FizzBuzz
        FizzBuzz fizzBuzzTest = new FizzBuzz(15);
        // get the NumberList of these 2 Objects
        ArrayList fizzBuzzNumberList = fizzBuzz.getNumberList();
        ArrayList fizzBuzzTestNumberList = fizzBuzzTest.getNumberList();
        // test the sizes of these 2 number list
        assertEquals(fizzBuzzNumberList.size(),fizzBuzzTestNumberList.size());
        // test the elements inside these 2 number list
        for(int i = 0 ; i < fizzBuzzNumberList.size() ; i++){
            assertEquals(fizzBuzzNumberList.get(i),fizzBuzzTestNumberList.get(i));
        }
        // test the output of these 2 fizzbuzz objects
        assertEquals(fizzBuzz.getOutPut(),fizzBuzzTest.getOutPut());
    }
    // Test if a right Exception is thrown when a String was given
    @Test
    void fizzBuzzWithException1() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = fizzBuzzControler.fizzBuzz("test");
        });
        assertEquals(exception.getMessage(),"Bitte geben Sie ein Integer im Bereich [-2147483648 , 2147483648] ein");
    }
    // Test a right if Exception is thrown when a too big Integer was given, this will take a little long time
    @Test
    void fizzBuzzWithException2() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = fizzBuzzControler.fizzBuzz("2147483647");
        });
        assertEquals(exception.getMessage(),"Out of Heap Space");
    }
    // Test if a right Exception is thrown when a number out of Integer Range was given
    @Test
    void fizzBuzzWithException3() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = fizzBuzzControler.fizzBuzz("2147483648");
        });
        assertEquals(exception.getMessage(),"Bitte geben Sie ein Integer im Bereich [-2147483648 , 2147483648] ein");
    }
    // Test if a right Exception is thrown when a number out of Integer Range was given
    @Test
    void fizzBuzzWithException4() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FizzBuzz fizzBuzz = fizzBuzzControler.fizzBuzz("2147488648");
        });
        assertEquals(exception.getMessage(),"Bitte geben Sie ein Integer im Bereich [-2147483648 , 2147483648] ein");
    }
    // Test a Exception is handled right
    @Test
    void handleException() {
        Map<String,String> map = fizzBuzzControler.handleException( new IllegalArgumentException("testing") );
        assertEquals(map.get("statusCode"),"500");
        assertEquals(map.get("errorDescription"),"testing");
    }
    // Test the test methode in class FizzBuzzController
    @Test
    void test1() {
        // fizzbuzz object created by methode test in class fizzbuzzcontroller
        FizzBuzz fizzBuzz = fizzBuzzControler.test();
        // fizzbuzz object created by controller in class FizzBuzz
        FizzBuzz fizzBuzzTest = new FizzBuzz(50);
        // get the NumberList of these 2 Objects
        ArrayList fizzBuzzNumberList = fizzBuzz.getNumberList();
        ArrayList fizzBuzzTestNumberList = fizzBuzzTest.getNumberList();
        // test the sizes of these 2 number list
        assertEquals(fizzBuzzNumberList.size(),fizzBuzzTestNumberList.size());
        // test the elements inside these 2 number list
        for(int i = 0 ; i < fizzBuzzNumberList.size() ; i++){
            assertEquals(fizzBuzzNumberList.get(i),fizzBuzzTestNumberList.get(i));
        }
        // test the output of these 2 fizzbuzz objects
        assertEquals(fizzBuzz.getOutPut(),fizzBuzzTest.getOutPut());
    }
}