package com.example.foodtec_assignment.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/size")
public class SizeController {

    private final SizeService sizeService;

    @Autowired
    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }


    @GetMapping("/allSizes")
    public ResponseEntity<List<Size>> getAllSizes() {
        List<Size> allSizes = sizeService.getAllSizes();
        return new ResponseEntity<>(allSizes, HttpStatus.OK);
    }

    @GetMapping("/Size/{id}")
    public ResponseEntity<Size> getSize(@PathVariable Long id) {
        Optional<Size> getSize = sizeService.getSizeById(id);
        return getSize.map(s -> new ResponseEntity<>(s, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createSize")
    public ResponseEntity<Size> createSize(@RequestBody Size size) {
        sizeService.createSize(size);
        return new ResponseEntity<>(size, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Size> updateSize(@PathVariable Long id, Size updatedSize) {
        try {
            sizeService.updateSize(id, updatedSize);
            return new ResponseEntity<>(updatedSize, HttpStatus.OK);
        } catch (SizeNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteSizeById(@PathVariable Long id) {
        sizeService.deleteSize(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
