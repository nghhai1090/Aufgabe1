package controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzErrorControllerTest {
    private FizzBuzzErrorController fizzBuzzErrorController;
    @BeforeEach
    void setUp() {
        fizzBuzzErrorController = new FizzBuzzErrorController();
    }
    // test the handleError methode if it returns a right map object to transfer into json
    @Test
    void handleError1() {
        // create a MockHttpServletRequest object for the parameter of methode  handleError
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute("javax.servlet.error.exception",new IllegalArgumentException("testing"));
        request.setAttribute("javax.servlet.error.status_code",500);
        // create the map object by calling  handleError
        Map<String,String> map = fizzBuzzErrorController.handleError( request );
        // test its key-value paar
        assertEquals(map.get("statusCode"),"500");
        assertEquals(map.get("errorDescription"),"testing");
    }
    // test the handleError methode if it returns a right map object to transfer into json
    @Test
    void handleError2() {
        // create a MockHttpServletRequest object for the parameter of methode  handleError
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute("javax.servlet.error.exception",null);
        request.setAttribute("javax.servlet.error.status_code",500);
        // create the map object by calling  handleError
        Map<String,String> map = fizzBuzzErrorController.handleError( request );
        // test its key-value paar
        assertEquals(map.get("statusCode"),"500");
        assertEquals(map.get("errorDescription"),"N/A");
    }

    @Test
    void getErrorPath() {
        assertNull(fizzBuzzErrorController.getErrorPath());
    }
}