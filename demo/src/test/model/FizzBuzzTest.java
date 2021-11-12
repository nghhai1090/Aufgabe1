package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizz ;
    FizzBuzz buzz ;
    FizzBuzz fizzBuzz ;
    FizzBuzz wederFizzNochBuzzNegativ ;
    FizzBuzz wederFizzNochBuzzPositiv ;

    @BeforeEach
    void setUp() {
        // creating fizzbuzz objects like its name
        fizz = new FizzBuzz(9);
        buzz = new FizzBuzz(10);
        fizzBuzz = new FizzBuzz(15);
        wederFizzNochBuzzNegativ = new FizzBuzz(-23);
        wederFizzNochBuzzPositiv = new FizzBuzz(23);
    }

    @Test
    void getNumberList() {
        // check if object fizz is created right
        int checkNumber = 1;
        ArrayList fizzNumberList = fizz.getNumberList();
        // its number list should have 9 elements
        assertEquals(fizzNumberList.size(),9);
        // test the number list is sorted in ascending order from 1 to 9
        for(int i = 0 ; i < fizzNumberList.size() ; i++){
            assertEquals(fizzNumberList.get(i),checkNumber);
            checkNumber ++;
        }
        // check if object buzz is created right
        checkNumber = 1;
        ArrayList buzzNumberList = buzz.getNumberList();
        // its number list should have 10 elements
        assertEquals(buzzNumberList.size(),10);
        // test the number list is sorted in ascending order from 1 to 10
        for(int i = 0 ; i < buzzNumberList.size() ; i++){
            assertEquals(buzzNumberList.get(i),checkNumber);
            checkNumber ++;
        }
        // check if object fizzbuzz is created right
        checkNumber = 1;
        ArrayList fizzBuzzNumberList = fizzBuzz.getNumberList();
        // its number list should have 15 elements
        assertEquals(fizzBuzzNumberList.size(),15);
        // test the number list is sorted in ascending order from 1 to 15
        for(int i = 0 ; i < fizzBuzzNumberList.size() ; i++){
            assertEquals(fizzBuzzNumberList.get(i),checkNumber);
            checkNumber ++;
        }
        // check if object wederFizzNochBuzzNegativ is created right
        checkNumber = 1;
        ArrayList wederFizzNochBuzzNegativNumberList = wederFizzNochBuzzNegativ.getNumberList();
        // its number list should have 25 elements
        assertEquals(wederFizzNochBuzzNegativNumberList.size(),25);
        // test the number list is sorted in decending order from 1 to -23
        for(int i = 0 ; i < wederFizzNochBuzzNegativNumberList.size() ; i++){
            assertEquals(wederFizzNochBuzzNegativNumberList.get(i),checkNumber);
            checkNumber = checkNumber - 1;
        }
        // check if object wederFizzNochBuzzPositiv is created right
        checkNumber = 1;
        ArrayList wederFizzNochBuzzPositivNumberList = wederFizzNochBuzzPositiv.getNumberList();
        // its number list should have 23 elements
        assertEquals(wederFizzNochBuzzPositivNumberList.size(),23);
        for(int i = 0 ; i < wederFizzNochBuzzPositivNumberList.size() ; i++){
            assertEquals(wederFizzNochBuzzPositivNumberList.get(i),checkNumber);
            checkNumber ++;
        }
    }
    // test the output of objects
    @Test
    void getOutPut() {
        assertEquals(wederFizzNochBuzzNegativ.getOutPut(),"-24");
        assertEquals(wederFizzNochBuzzPositiv.getOutPut(),"24");
        assertEquals(fizzBuzz.getOutPut(),"FizzBuzz");
        assertEquals(buzz.getOutPut(),"Buzz");
        assertEquals(fizz.getOutPut(),"Fizz");
    }
    // test setNumberList methode to set a new number list
    @Test
    void setNumberList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        fizzBuzz.setNumberList(arrayList);
        assertEquals(fizzBuzz.getNumberList().get(0),1);
        assertEquals(fizzBuzz.getNumberList().get(1),2);
        assertEquals(fizzBuzz.getNumberList().get(2),3);
    }
    // test setOutPut to set new output
    @Test
    void setOutPut() {
        fizzBuzz.setOutPut("test");
        assertEquals(fizzBuzz.getOutPut(),"test");
    }
}