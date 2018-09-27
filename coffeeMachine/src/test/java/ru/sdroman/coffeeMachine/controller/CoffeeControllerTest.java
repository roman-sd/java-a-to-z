package ru.sdroman.coffeeMachine.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.sdroman.coffeeMachine.domain.DrinkListInit;
import ru.sdroman.coffeeMachine.domain.Ingredients;
import ru.sdroman.coffeeMachine.domain.CoffeeMachineStatus;
import ru.sdroman.coffeeMachine.repository.CoffeeMachineRepository;
import ru.sdroman.coffeeMachine.service.CoffeeMachineService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author sdroman
 * @since 09.2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CoffeeController.class)
public class CoffeeControllerTest {

    private MockMvc mvc;

    @MockBean
    private CoffeeMachineService service;

    @MockBean
    private CoffeeMachineRepository repository;

    @Before
    public void setUp() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates");
        viewResolver.setSuffix(".html");
        this.mvc = standaloneSetup(new CoffeeController(service))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void whenGetCoffeeCupShouldPageIndex() throws Exception {
        given(service.getMachineStatus())
                .willReturn(new CoffeeMachineStatus());

        mvc.perform(
                get("/index").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("index")
        );
    }

    @Test
    public void whenPostCoffeeThenUpdate() throws Exception {
        Ingredients ingredients = new DrinkListInit().getDrinks().get(2).getIngredients();
        mvc.perform(
                post("/index").param("drinkId", "2")
        ).andExpect(
                status().is3xxRedirection()
        );
        verify(service, times(1)).updateState(ingredients);
    }

    @Test
    public void whenGetIngredientsThenPageAdd() throws Exception {
        mvc.perform(
                get("/add").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("add")
        );
    }

    @Test
    public void whenPostIngredientThenAdd() throws Exception {
        Ingredients ingredients = new Ingredients(500, 200, 70);
        mvc.perform(
                post("/add")
                        .param("water", Integer.toString(ingredients.getWater()))
                        .param("milk", Integer.toString(ingredients.getMilk()))
                        .param("beans", Integer.toString(ingredients.getBeans()))
        ).andExpect(
                status().is3xxRedirection()
        );
        verify(service, times(1)).addProduct(ingredients);
    }

    @Test
    public void whenGetCleaningThenCleaning() throws Exception {
        mvc.perform(
                get("/cleaning").accept(MediaType.TEXT_HTML)
        ).andExpect(status().isOk());
    }

    @Test
    public void whenExceptionAreCaughtThenExceptionPage() throws Exception {
        mvc.perform(
                get("/error")
        ).andExpect(status().isOk()
        ).andExpect(view().name("error"));
    }
}