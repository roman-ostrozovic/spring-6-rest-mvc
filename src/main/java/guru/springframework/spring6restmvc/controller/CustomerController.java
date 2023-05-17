package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.modul.Beer;
import guru.springframework.spring6restmvc.modul.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public List<Customer> listCustomers(){
        return customerService.listConsumers();
    }
    @GetMapping(value = "{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId){

        log.debug("Get Customer by Id - in controller");

        return customerService.getById(customerId);
    }

}
