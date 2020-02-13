package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo.domain.MenuItemRepositoryImpl;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import kr.co.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // Spring 을 이용해서 Test를 실행할 수 있도록 함
@WebMvcTest(RestaurantController.class) // 특정 컨트롤러(RestaurantController)를 Test를 한다는 것을 명시할 수 있음
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    // Controller에 원하는 객체를 주입을 할 수 있다.
    // @Component/@Autowired 를 사용 시 Test 쪽에서 선언되어야 하는 어노테이션
    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;
    @SpyBean(MenuItemRepositoryImpl.class)
    private MenuItemRepository menuItemRepository;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                    containsString("\"id\":1004")
            ))
            .andExpect(content().string(
                    containsString("\"name\":\"Bob zip\"")
            ));
    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("\"id\":1004")
            ))
            .andExpect(content().string(
                containsString("\"name\":\"Bob zip\"")
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
                    containsString("\"name\":\"Cyber Food\"")
            ));
    }
}