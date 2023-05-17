package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.modul.Beer;
import guru.springframework.spring6restmvc.modul.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity getCustomerById(@RequestBody Customer customer){

        log.debug("Create new Customer - in controller");

        Customer savedCustomer = customerService.handlePost(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(savedCustomer, headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value="{customerId}")
    public ResponseEntity deleteById(@PathVariable UUID customerId) {

        customerService.deleteByBeerId(customerId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customerId);

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "{customerId}")
    public ResponseEntity updateCustomerById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){

        log.debug("Update existing Customer - in controller");

        Customer existingCustomer = customerService.updateById(customerId, customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + existingCustomer.getId().toString());

        return new ResponseEntity(existingCustomer, headers, HttpStatus.CREATED);
    }

    @PatchMapping(value="{customerId}")
    public ResponseEntity updateBeerPatchById(@PathVariable UUID customerId, @RequestBody Customer customer) {

        customerService.updateCustomerPatchById(customerId, customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customerId);

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }

}
