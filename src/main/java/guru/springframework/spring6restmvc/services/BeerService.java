package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.modul.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {
    Beer getBeerById(UUID id);
}
