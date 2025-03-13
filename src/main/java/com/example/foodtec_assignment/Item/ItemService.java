package com.example.foodtec_assignment.Item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) throws ItemNotFoundException {
        Optional<Item> checkItem = itemRepository.findById(id);
        if(checkItem.isPresent()){
            return itemRepository.save(item);
        } else {
            throw new ItemNotFoundException("Item: " + item.getName() + " not found.");
        }
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
