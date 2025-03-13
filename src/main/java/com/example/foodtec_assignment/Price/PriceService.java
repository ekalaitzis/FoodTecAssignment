package com.example.foodtec_assignment.Price;

import com.example.foodtec_assignment.Size.Size;
import com.example.foodtec_assignment.Size.SizeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
    
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getPriceById(Long id) {
        return priceRepository.findById(id);
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price createPrice(Price price) {
        System.out.println(price.toString() + " service");
        return priceRepository.save(price);
    }

    public Price updatePrice(Long id, Price price)throws SizeNotFoundException {
        Optional<Price> checkPrice = priceRepository.findById(id);
        if (checkPrice.isPresent()) {
            return priceRepository.save(price);
        } else {
            throw new SizeNotFoundException("Price not found.");
        }
    }


    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }
}
