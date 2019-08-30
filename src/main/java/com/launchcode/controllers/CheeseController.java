package com.launchcode.controllers;

import com.launchcode.models.Cheese;
import com.launchcode.models.CheeseData;
import com.launchcode.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        model.addAttribute("cheese", CheeseData.getCheeseById(cheeseId));
        model.addAttribute("title","Edit Cheese");
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(int cheeseId, String name, String description,String type,int rating){
        CheeseData.updateCheese(cheeseId,name,description,type,rating);
        //redirect to /cheese
        return "redirect:/cheese";
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String processCheeseData(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title","Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }
        CheeseData.addCheese(cheese);
        //redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("title","Delete Cheese");
        model.addAttribute("cheeses",CheeseData.getAll());
        return "cheese/delete";
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String processDeleteCheeseData(@RequestParam int cheeseId){
        CheeseData.deleteCheese(cheeseId);
        //redirect to /cheese
        return "redirect:";
    }
}
