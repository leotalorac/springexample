package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        List<String> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user.getName()));
        model.put("message", users );
        return "welcome";
    }
    @RequestMapping(value = "/formuser", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("userHome", "user", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user")User user,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", user.getName());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("id", user.getId());
        return "userView.jsp";
    }


}

