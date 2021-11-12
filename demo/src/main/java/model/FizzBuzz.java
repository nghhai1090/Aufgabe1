package model;

import java.util.ArrayList;

/**
 * Model of FizzBuzz,
 * the logic of object Fizzbuzz will be placed here, in this class will the sequence of numbers from 1 to the numberInput
 * as an array list and the output ("Fizz","Buzz", ect) as a String be saved.
 * This class is also important for the output of final result in JSON Format
 */
public class FizzBuzz {
    /**
     *  the sequence of numbers from 1 to the numberInput will be saved here for the output in JSON Format
     */
    private ArrayList numberList;
    /**
     * this variable ist to save that output besides the sequence of number as in the excercise's requirements.
     * output = Fizz when the numberInput is divisible by 3
     * output = Buzz when the numberInput is divisible by 5
     * output = Fizzbuzz when the numberInput is divisible by 3 and 5
     * output = the next number of NumberInput in the other falls
     */
    private String outPut;

    /**
     * Contructor of Class Fizzbuzz. Here will be the Attributs numberList and outPut generated
     * @param numberInput an Integer as input from Spring Boot Application
     */
    public FizzBuzz(int numberInput) {
        numberList = generateNumberList(numberInput);
        outPut = generateOutput(numberInput);
    }

    /**
     * This Methode is to generate the sequence of numbers from 1 to the numberInput . When numberInput is negative, then
     * an ArrayList in the Area [numberInput, 1] will be generated.  When numberInput is positive, then an ArrayList in
     * the Area [1,numberInput] will be generated.
     * @param numberInput an Integer as input from Spring Boot Application
     * @return an Array List with sequence of numbers from 1 to the numberInput
     */
    private ArrayList generateNumberList(int numberInput) {
        // generate empty array list
        ArrayList resultList = new ArrayList();
        // if numberInput is negative
        if(numberInput<1) {
            for(int i = 0 ; i < Math.abs(numberInput) +2 ; i ++ )
            {
                // add numbers in the Area [numberInput, 1] to the array list resultlist
                resultList.add(1-i);
            }
        }
        // if numberInput is positive
        else {
            for(int i = 0 ; i < numberInput ; i ++)
            {
                // add numbers in the Area [1,numberInput] to the array list resultlist
                resultList.add(1+i);
            }
        }
        return resultList;
    }

    /**
     * This Methode is to generate the output besides the sequence of number as in the excercise's requirements.
     * @param numberInput an Integer as input from Spring Boot Application
     * @return * output = Fizz when the numberInput is divisible by 3
     *         * output = Buzz when the numberInput is divisible by 5
     *         * output = Fizzbuzz when the numberInput is divisible by 3 and 5
     *         * output = the next number of NumberInput in the other falls
     */
    private String generateOutput(int numberInput){
        // generate firstly the empty output string of this method
        String result = "";
        // if numberInput is divisible by 3
        if(numberInput % 3 == 0)
        {
            //output = Fizz
            result = result + "Fizz";
        }
        // if numberInput is divisible by 5
        if(numberInput % 5 == 0)
        {
            // output = Buzz
            result = result + "Buzz";
        }
        // the fall the numberInput is divisible by 3 and 5 is skipped as it is included in the upper 2 falls
        // other falls
        if(numberInput % 3 != 0 && numberInput % 5 != 0) {
            // if numberInput is negative
            if(numberInput<0) {
                // next number of it should also be in the negative direction
                int nextNumber = numberInput - 1;
                // save next number to variable result
                result = Integer.toString(nextNumber);
            }
            // if numberInput is positive
            else {
                // next number of it should also be in the positive direction
                int nextNumber = numberInput + 1;
                // save next number to variable result
                result = Integer.toString(nextNumber);
            }
        }
        return  result;
    }

    /**
     * Getter of attribute numberList
     * @return the sequence of numbers from 1 to the numberInput
     */
    public ArrayList getNumberList() {
        return numberList;
    }

    /**
     * Getter of Attribute outPut
     * @return  variable outPut ist to save that output besides the sequence of number as in the excercise's requirements.
     */
    public String getOutPut() {
        return outPut;
    }

    /**
     * Setter of attribute numberList
     * @param numberList the sequence of numbers from 1 to the numberInput
     */
    public void setNumberList(ArrayList numberList) {
        this.numberList = numberList;
    }

    /**
     * Setter of attribute outPut
     * @param outPut variable outPut ist to save that output besides the sequence of number as in the excercise's requirements.
     */
    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }
}
