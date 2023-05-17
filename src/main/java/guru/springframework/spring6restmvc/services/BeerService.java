package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.modul.Beer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface BeerService {

    List<Beer> listBeers();
    Beer getBeerById(UUID id);
}
