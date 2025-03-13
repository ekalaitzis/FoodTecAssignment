package com.example.foodtec_assignment.Price;

import com.example.foodtec_assignment.Size.SizeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/allPrices")
    public ResponseEntity<List<Price>> getAllPrices() {
        List<Price> allPrices = priceService.getAllPrices();
        return new ResponseEntity<>(allPrices, HttpStatus.OK);
    }

    @GetMapping("/Price/{id}")
    public ResponseEntity<Price> getPrice(@PathVariable Long id) {
        Optional<Price> getPrice = priceService.getPriceById(id);
        return getPrice.map(i -> new ResponseEntity<>(i, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createPrice")
    public ResponseEntity<Price> createPrice(@RequestBody Price price) {
        System.out.println(price.toString() + " controller");

        priceService.createPrice(price);
        return new ResponseEntity<>(price, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, Price updatedPrice) throws SizeNotFoundException {
        priceService.updatePrice(id, updatedPrice);
        return new ResponseEntity<>(updatedPrice, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePriceById(@PathVariable Long id) {
        priceService.deletePrice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
