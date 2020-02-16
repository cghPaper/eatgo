package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // Spring 을 이용해서 Test를 실행할 수 있도록 함
@WebMvcTest(RestaurantController.class) // 특정 컨트롤러(RestaurantController)를 Test를 한다는 것을 명시할 수 있음
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    // Controller 를 test 하는데 불필요한 것들은 MockBean 어노테이션을 통해서 가짜로 만들어줌으로써
    // Controller test 는 controller test 하는 것에 집중할 수 있도록 함
    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "JOCKER House", "Seoul"));

        given(restaurantService.getRestaurants()).willReturn(restaurants);

        mvc.perform(get("/restaurants"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                    containsString("\"id\":1004")
            ))
            .andExpect(content().string(
                    containsString("\"name\":\"JOCKER House\"")
            ));
    }

    @Test
    public void detail() throws Exception {
        Restaurant restaurant1 = new Restaurant(1004L, "JOCKER House", "Seoul");
        restaurant1.addMenuItem(new MenuItem("Kimchi"));

        Restaurant restaurant2 = new Restaurant(2020L, "Cyber food", "Seoul");
        restaurant2.addMenuItem(new MenuItem("Kimchi"));

        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

        mvc.perform(get("/restaurants/1004"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("\"id\":1004")
            ))
            .andExpect(content().string(
                containsString("\"name\":\"JOCKER House\"")
            ))
            .andExpect(content().string(
                    containsString("Kimchi")
            ));

        mvc.perform(get("/restaurants/2020"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                    containsString("\"id\":2020")
            ))
            .andExpect(content().string(
                    containsString("\"name\":\"Cyber food\"")
            ))
            .andExpect(content().string(
                    containsString("Kimchi")
            ));
    }
}