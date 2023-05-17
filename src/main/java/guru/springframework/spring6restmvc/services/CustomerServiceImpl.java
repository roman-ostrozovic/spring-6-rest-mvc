package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.modul.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, Customer> customerMap;
    CustomerServiceImpl() {

        customerMap = new HashMap<>();
        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("John Wick")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("janko Mrkvička")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Frederik Ábel")
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        customerMap.put(customer1.getId(),customer1);
        customerMap.put(customer2.getId(),customer2);
        customerMap.put(customer3.getId(),customer3);

    }
    @Override
    public List<Customer> listConsumers() {
        return customerMap.values().stream().toList();
    }

    @Override
    public Customer getById(UUID consumerId) {
        return customerMap.get(consumerId);
    }
}
