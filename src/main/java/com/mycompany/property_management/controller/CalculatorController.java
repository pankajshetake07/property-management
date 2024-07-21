package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")//class level mapping fo url to a controller class
public class CalculatorController {

    //By using RequestParam Annotation
    //http://localhost:8080/api/v1/calculator/add?no1=3.5&no2=3.5
    @GetMapping("/add")//method level mapping of a url to a controller function
    //variable name could be different
    public Double add(@RequestParam("num1") Double num1,
                      @RequestParam("num2") Double num2){
        return num1 + num2;
    }

    //Another way to pass value by using PathVariable Annotation
    //http://localhost:8080/api/v1/calculator/sub/9.5/3.5
    @GetMapping("/sub/{num1}/{num2}") //map the values of the urls to java variables method
    public Double substract(@PathVariable("num1") Double num1,
                            @PathVariable("num2") Double num2){
        Double result = null;
        if (num1 > num2){
            result = num1 - num2;
        } else {
            result = num2 - num1;
        }
        return  result;
    }


    //we can combine both @RequestParam and @PathVariable
    //in URL first give the value of @PathVariable like shown below URL
    //http://localhost:8080/api/v1/calculator/addition/4/5?num1=4
    @GetMapping("/addition/{num2}/{num3}")
    public int addition(@RequestParam("num1") int num1,
                        @PathVariable("num2") int num2,
                        @PathVariable("num3") int num3){
        return num1 + num2 + num3;
    }


    @PostMapping("/mul")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1() * calculatorDTO.getNum2() * calculatorDTO.getNum3();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
