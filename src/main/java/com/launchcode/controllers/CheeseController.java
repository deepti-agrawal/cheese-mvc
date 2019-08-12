package com.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {

    static ArrayList<String> cheese = new ArrayList<>();

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("cheeses",cheese);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String processCheeseData(@RequestParam String cheeseName){
        cheese.add(cheeseName);
        //redirect to /cheese
        return "redirect:";
    }
}
