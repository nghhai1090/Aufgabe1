package controller;
import model.FizzBuzz;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import service.FizzBuzzService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller Layer of FizzBuzz Application
 * to ineract with the Client HTTP Requests
 */
@RestController
public class FizzBuzzControler {
    /**
     * Fizzbuzz service to handle request
     */
    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    /**
     * this Methode is to handle the mapping /fizzbuzz  with a request parameter from the client
     * . This will then create a new Fizzbuzz object then return as JSON Format to the client, or throw
     * Exceptions , depending on the request parameter
     * @param input request parameter from the client , an acceptable request parameter should be an integer , then
     * integer values are discreet
     * @return  a new Fizzbuzz object if request parameter is acceptable.
     * This will be returned to client as JSON Format thank to Spring Boot.
     *  Or IllegalArgumentException("Bitte geben Sie ein Integer im Bereich [-2147483648 , 2147483648] ein") if no Integer is given,
     *  or IllegalArgumentException("Out of Heap Space") if the Integer is too big (too small)
     */
    @GetMapping("/fizzbuzz")
    public FizzBuzz fizzBuzz(@RequestParam(value = "input") String input) {
        try {
            // parse input to Integer
            int numberInput = Integer.parseInt(input);
            // create FizzBuzz object with fizzbuzz service then return
            return fizzBuzzService.createFizzBuzz(numberInput);
        }
        // if no integer was given
        catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Bitte geben Sie ein Integer im Bereich [-2147483648 , 2147483648] ein");
        }
        // if integer was too big or too small, there would be not enough heap space to create the
        // array list to save the sequence of numbers from 1 to input
        catch (OutOfMemoryError exception) {
            throw new IllegalArgumentException("Out of Heap Space");
        }
    }

    /**
     * This Methode is to handle the exceptions thrown from the upper Methode
     * @param throwable Exceptions, this could be  IllegalArgumentException or any type of Exceptions
     * @return a Hasp map with keys statusCode and errorDescription and its values created by fizzBuzzService .
     * This will be returned to client as JSON Format thank to Spring Boot.
     */
    @ExceptionHandler(Throwable.class)
    public Map<String,String> handleException(Throwable throwable) {
        return fizzBuzzService.errorOutput("500",throwable.getMessage());
    }

    /**
     * this Methode is to test the FizzBuzz Application
     * @return a new Fizzbuzz object with parameter 50
     */
    @GetMapping("/")
    public FizzBuzz test(){
        return new FizzBuzz(50);
    }

}
