package ru.sdroman.carstore;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.sdroman.carstore.domain.Order;
import ru.sdroman.carstore.repository.OrderRepository;
import ru.sdroman.carstore.service.CarService;
import ru.sdroman.carstore.service.OrderService;
import ru.sdroman.carstore.service.UserService;
import ru.sdroman.carstore.service.impl.OrderServiceImpl;
import ru.sdroman.carstore.web.OrderController;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author sdroman
 * @since 08.2018
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private CarService carService;

    @MockBean
    private UserService userService;

    @MockBean
    private OrderRepository orderRepository;

    @Before
    public void setUp() {
        orderService = new OrderServiceImpl(orderRepository);
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates");
        viewResolver.setSuffix(".html");

        this.mvc = standaloneSetup(new OrderController(orderService, carService, userService))
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    @WithMockUser(username = "root", roles = {"admin"})
    public void whenGetOrdersThenPageOrders() throws Exception {
        given(
                this.orderService.getOrders()
        ).willReturn(
                new ArrayList<Order>(
                        Lists.newArrayList(new Order()))
        );

        this.mvc.perform(
                get("/index").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("index")
        );
    }

    @Test
    @WithMockUser(username = "root", roles = {"admin"})
    public void whenAddOrderThenPageInfo() throws Exception {
        Order order = new Order();
        given(this.orderService.create(order)).willReturn(order);

        this.mvc.perform(
                get("/add").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("add")
        );
    }

    @Test
    @WithMockUser(username = "root", roles = {"admin"})
    public void whenGetOrderDetailsThenPageInfo() throws Exception {
        final int id = 55;

        given(Optional.of(this.orderService.getOrder(id))).willReturn(Optional.of(new Order()));

        this.mvc.perform(
                get(String.format("/order/?id=%s", id)).accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("info")
        );
    }
}