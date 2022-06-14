package com.example.assignment.service.impl;


import com.example.assignment.exception.ResourceNotFoundException;
import com.example.assignment.model.Item;
import com.example.assignment.repository.ItemRepository;
import com.example.assignment.service.ItemService;
import org.springframework.stereotype.Service;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

   public Item getItemById(long id){
       Optional <Item> item= itemRepository.findById(id);
       if (item.isPresent()) return item.get();
       else throw  new ResourceNotFoundException("Item " ,"Id",id);
    }

    public Item updateItem(Item item,long id){
        Item existingItem= itemRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Item " ,"Id",id));
        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setExpireDate(item.getExpireDate());
        existingItem.setPrescriptionRequired(item.getPrescriptionRequired());
        existingItem.setQty(item.getQty());

        itemRepository.save(existingItem);
        return existingItem;
    }

    @Override
    public void deleteItem(long id) {
        Item existingItem= itemRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Item " ,"Id",id));

        itemRepository.deleteById(existingItem.getId());
    }

}
