package com.example.ProjectOne.Controller;

import com.example.ProjectOne.Service.CalService;
import com.example.ProjectOne.Service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Calculate")
public class Calculator {

    @Autowired
    CalService cal ;

    @Autowired
    InterestService interest;


    @GetMapping("/{oper}/{firstnumber}/{secondnumber}")
    public ResponseEntity<Object> Oper(
            @PathVariable ("oper") String oper,
            @PathVariable ("firstnumber") double first,
            @PathVariable ("secondnumber") double second
            ) {
        switch (oper) {
            case "Add" :
                return new ResponseEntity<>(cal.add(first,second),HttpStatus.OK);
            case "Subtract" :
                return new ResponseEntity<>(cal.sub(first,second),HttpStatus.OK);
            case "Multiply" :
                return new ResponseEntity<>(cal.mul(first,second),HttpStatus.OK);

            case "Divide" :
                if (second == 0) {
                    return new ResponseEntity<>("Output", HttpStatus.BAD_REQUEST);
                }else {
                    return new ResponseEntity<>(cal.div(first, second), HttpStatus.OK);
                }
        }


        return new ResponseEntity<>("Enter a Valid Operation" , HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{Interest}/{Principle}/{Time}/{Rate}")
    public ResponseEntity<Object> interest(
            @PathVariable("Interest") String intrst,
            @PathVariable("Principle") double prin,
            @PathVariable("Time") double time,
            @PathVariable("Rate") double rate
    ) {
        switch (intrst) {
            case "SI" :
                if (prin != 0 && rate != 0 && time != 0) {
                    return new ResponseEntity<>("Simple Interest is :" + interest.SampleInterest(prin, time, rate), HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("Zero is not accepted while calculating Interest" , HttpStatus.BAD_REQUEST);
                }
            case "CI":
                if (prin != 0 && rate != 0 && time != 0) {
                    return new ResponseEntity<>("Compound Interest is :" + interest.CompoundInterest(prin, time, rate), HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("Zero is not accepted while calculating Interest" , HttpStatus.BAD_REQUEST);
                }
        }

        return new ResponseEntity<>("Enter a Valid Operation" , HttpStatus.BAD_REQUEST);
    }
}
