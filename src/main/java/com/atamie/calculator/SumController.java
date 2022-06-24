package com.atamie.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SumController {
    @Autowired
    private Sum sum;
    @Autowired
    private RestClientClass restClientClass;

   // @Cacheable(value = "sum")
    @RequestMapping("/sum")
    @GetMapping
    public String getSum(@RequestParam("a") int a, @RequestParam("b") int b) throws InterruptedException{
        Thread.sleep(5000);
        return String.valueOf(sum.sum(a,b));
    }
    @RequestMapping("/subtract")
    @GetMapping
    public  String getDifference(@RequestParam("a") int a, @RequestParam("b") int b){
        return String.valueOf(sum.subtract(a,b));
    }
    @RequestMapping("/multiply")
    @GetMapping
    public String getProduct(@RequestParam("a") int a, @RequestParam("b") int b){
        return  String.valueOf(sum.multiply(a,b));
    }

    @GetMapping("/services")
    public ResponseEntity<CustomServiceProviders> getAllService(){
        return  restClientClass.getAllAirtimeServiceProviders();
    }
}
