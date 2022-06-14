package com.example.assignment.service;

import com.example.assignment.model.Item;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemService {
    Item saveItem(Item item);
    List <Item> getAllItems();

    Item getItemById( long id);

    Item updateItem(Item item,long id);

    void deleteItem(long id);

    List <Item> filterItems( String query);

}
