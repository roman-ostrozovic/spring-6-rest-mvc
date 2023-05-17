package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.modul.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CustomerService {

    List<Customer> listConsumers();

    Customer getById(UUID consumerId);

    Customer handlePost(Customer customer);

    Customer updateById(UUID customerId, Customer customer);

    void updateCustomerPatchById(UUID customerId, Customer customer);

    void deleteByBeerId(UUID customerId);
}
