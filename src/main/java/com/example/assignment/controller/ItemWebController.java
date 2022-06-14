package com.example.assignment.controller;

import com.example.assignment.exception.ResourceNotFoundException;
import com.example.assignment.model.Item;
import com.example.assignment.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("web")
public class ItemWebController {

    private ItemService itemService;


    public ItemWebController(ItemService itemService) {
        super();
        this.itemService = itemService;
    }

    @GetMapping
    public String  homepage(Model model){

        List <Item> items=  itemService.getAllItems();
        model.addAttribute("items",items);
        return "./index";
    }

    @GetMapping("/create")
    public String  show_create(Model model ,RedirectAttributes  redirectAttributes ){

//        model.addAttribute("item",new Item());
        model.addAttribute("item",new Item());
        model.addAttribute("title","Create New");
        return "create";

    }

    @PostMapping("item/save")
    public String saveItem(Item item){
        itemService.saveItem(item);
        return "redirect:/";
    }
    @GetMapping("/editItem/{id}")
    public String  show_edit(@PathVariable("id") Integer itemId, Model model){

        try {
            Item item =itemService.getItemById(itemId);
            model.addAttribute("item",item);
            model.addAttribute("title","Edit (Id: "+itemId+")");
            return "create";
        }
        catch (ResourceNotFoundException e) {
            return "redirect:/";
        }
    }

    @GetMapping("/deleteItem/{id}")
    public String  delete(@PathVariable("id") Integer itemId) throws ResourceNotFoundException{

        try {
            itemService.deleteItem(itemId);


        }
        catch (ResourceNotFoundException e) {
            return "redirect:/";
        }
        return "redirect:/";
    }
}
