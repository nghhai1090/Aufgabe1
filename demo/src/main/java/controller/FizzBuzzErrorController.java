package controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FizzBuzzService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller Layer to handle errors
 */
@Controller
public class FizzBuzzErrorController implements ErrorController {

    /**
     * Fizzbuzz service to handle request
     */
    private final FizzBuzzService fizzBuzzService = new FizzBuzzService();

    /**
     * this Methode is to handle the mapping /error , occurs when unknown exception is thrown
     * @param request the reply from server
     * @return a Hasp map with keys statusCode and errorDescription and its values created by fizzBuzzService .
     */
    @RequestMapping("/error")
    @ResponseBody
    public Map<String, String> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        String errorDescription = "";
        if (exception==null) {
            errorDescription = "N/A";
        }
        else{
            errorDescription = exception.getMessage();
        }
        return fizzBuzzService.errorOutput(Integer.toString(statusCode), errorDescription);
    }

    /**
     * override Methode getErrorPath from parent class ErrorController
     * @return
     */
    @Override
    public String getErrorPath() {
        return null;
    }
}
