package ru.sdroman.carstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sdroman.carstore.models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author sdroman
 * @since 08.2018
 */
@Controller
public class UserController {

    private final List<User> users = new CopyOnWriteArrayList<>();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUser(ModelMap modelMap) {
        modelMap.addAttribute("users", this.users);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        this.users.add(user);
        return "redirect:users.do";
    }
}
