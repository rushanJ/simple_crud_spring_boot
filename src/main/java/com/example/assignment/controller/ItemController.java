package com.example.assignment.controller;

import com.example.assignment.model.Item;
import com.example.assignment.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("api/item")
public class ItemController {

    private ItemService itemService;


    public ItemController(ItemService itemService) {
        super();
        this.itemService = itemService;
    }



    @PostMapping
    public ResponseEntity <Item> saveItem(  @RequestBody Item item){
        return  new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping ("{id}")
    public ResponseEntity <Item> getItemById(  @PathVariable("id") long itemId){
        return  new ResponseEntity<Item>(itemService.getItemById(itemId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity <Item> updateItem(  @PathVariable("id") long itemId, @RequestBody Item item){
        return  new ResponseEntity<Item>(itemService.updateItem(item,itemId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <String> deleteItem(  @PathVariable("id") long itemId){
        itemService.deleteItem(itemId);
        return  new ResponseEntity<String>("Item Deleted Succesfully!", HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Item> filterItems(@RequestParam ("name") String name ) {

        return itemService.filterItems("name="+name);
    }





}
