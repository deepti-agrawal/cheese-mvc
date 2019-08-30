package com.launchcode.controllers;

import com.launchcode.models.User;
import com.launchcode.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="user")
public class UserController {

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("users",UserData.getAll());
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("title","Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    //make sure that error must follow @Model attribute i.e. if @model is param 1 than error has to be param 2
    @RequestMapping(value="add",method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User user, Errors errors, Model model, String verify){
        if(errors.hasErrors()) {
            model.addAttribute("title","Add User");
            return "user/add";
        }
        if (user.getPassword()==null || !user.getPassword().equals(verify)) {
            model.addAttribute("passwordError", "Passwords does not match..");
            return "user/add";
        }
        UserData.addUser(user);
        return "redirect:";
    }
}