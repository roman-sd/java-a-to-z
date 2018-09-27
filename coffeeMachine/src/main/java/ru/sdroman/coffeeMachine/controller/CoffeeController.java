package ru.sdroman.coffeeMachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sdroman.coffeeMachine.domain.Drink;
import ru.sdroman.coffeeMachine.domain.DrinkDTO;
import ru.sdroman.coffeeMachine.domain.DrinkListInit;
import ru.sdroman.coffeeMachine.domain.Ingredients;
import ru.sdroman.coffeeMachine.exception.CleaningException;
import ru.sdroman.coffeeMachine.exception.IngredientException;
import ru.sdroman.coffeeMachine.service.CoffeeMachineService;

/**
 * CoffeeController handles Get/Post request by returning the name of view.
 *
 * @author sdroman
 * @since 09.2018
 */
@Controller
public class CoffeeController {

    private final DrinkListInit drinkListInit = new DrinkListInit();

    private CoffeeMachineService service;

    @Autowired
    public CoffeeController(CoffeeMachineService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String coffeeView(ModelMap model) {
        DrinkDTO form = new DrinkDTO();
        model.addAttribute("drinkForm", form);
        model.addAttribute("totalProduct", service.getMachineStatus());
        model.addAttribute("drinks", drinkListInit.getDrinks());
        return "index";
    }

    @PostMapping("/index")
    public String updateCoffeeMachine(@ModelAttribute("drinkId") int id, RedirectAttributes redirectAttributes) {
        Drink drink = drinkListInit.getDrinks().get(id);
        service.updateState(drink.getIngredients());
        redirectAttributes.addFlashAttribute("message", drink.getName());
        return "redirect:/index";
    }

    @GetMapping("/add")
    public String addIngredientsView(Model model) {
        model.addAttribute("coffee", new DrinkDTO());
        return "add";
    }

    @PostMapping("/add")
    public String addProducts(@ModelAttribute DrinkDTO drink) {
        Ingredients ingredients = new Ingredients(drink.getWater(), drink.getMilk(), drink.getBeans());
        service.addProduct(ingredients);
        return "redirect:/index";
    }

    @GetMapping("/cleaning")
    public String cleaningCoffeeMachine(Model model) {
        model.addAttribute("cleaningMsg", "Successful cleaning");
        service.cleanMachine();
        return "cleaning";
    }

    @ExceptionHandler({CleaningException.class, IngredientException.class})
    @GetMapping("/error")
    public ModelAndView cleaningException(RuntimeException ex) {
        ModelAndView model = new ModelAndView("error");
        model.addObject("errorMsg", ex.getMessage());
        return model;
    }
}
