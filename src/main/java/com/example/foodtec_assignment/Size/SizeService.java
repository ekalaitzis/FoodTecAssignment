package com.example.foodtec_assignment.Size;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public Optional<Size> getSizeById(Long id) {
        return sizeRepository.findById(id);
    }

    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    public Size createSize(Size size) {
        return sizeRepository.save(size);
    }

    public Size updateSize(Long id, Size size) throws SizeNotFoundException {
        Optional<Size> checkSize = sizeRepository.findById(id);
        if (checkSize.isPresent()) {
            return sizeRepository.save(size);
        } else {
            throw new SizeNotFoundException("Size: " + size.getName() + " not found.");
        }
    }

    public void deleteSize(Long id) {
        sizeRepository.deleteById(id);
    }
}
