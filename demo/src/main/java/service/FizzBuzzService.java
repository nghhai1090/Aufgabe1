package service;

import model.FizzBuzz;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service Layer of FizzBuzz Application
 * to handle the requests from Controller Layer
 */
@Service
public class FizzBuzzService {
    /**
     * Methode to create new FizzBuzz object and then return
     * @param numberInput  an Integer as input from Spring Boot Application
     * @return new FizzBuzz object. This object  will be returned to client as JSON Format thank to Spring Boot
     */
    public FizzBuzz createFizzBuzz(int numberInput) {
        //create new FizzBuzz object by calling its contructor with parameter numberInput and then return
        return new FizzBuzz(numberInput);
    }

    /**
     * Methode to create error messages in JSON Format
     * @param statusCode HTTP Response Status Code (500)
     * @param description Error description
     * @return a Hasp map with keys statusCode and errorDescription and its values.
     * This will be returned to client as JSON Format thank to Spring Boot
     */
    public Map<String,String> errorOutput(String statusCode, String description) {
        // create empty Hashmap
        HashMap<String,String> map = new HashMap<>();
        // add parameters to its keys
        map.put("statusCode",statusCode);
        map.put("errorDescription",description);
        return  map;
    }
}
