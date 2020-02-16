package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Componenet 의 일종
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

//    @Autowired // Controller 를 만들어 줄 때 Spring 이 알아서 RestaurantRepository 를 생성해서 넣어줌
//    private RestaurantRepository restaurantRepository;
//    @Autowired
//    private MenuItemRepository menuItemRepository;
    // Autowird 어노테이션을 쓰기 전에 객체 생성 방법
    //private RestaurantRepository repository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        //List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);
//        기본정보 + 메뉴정보
//        Restaurant restaurant = restaurantRepository.findById(id);
//        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
//        restaurant.setMenuItems(menuItems);
        return restaurant;
    }
}
