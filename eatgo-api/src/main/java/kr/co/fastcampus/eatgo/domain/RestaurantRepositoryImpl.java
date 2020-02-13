package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component // RestaurantRepository를 Spring 이 직접 관리
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantRepositoryImpl() {
        restaurants.add(new Restaurant(1004L,"Bob zip", "Seoul"));
        restaurants.add(new Restaurant(2020L,"Cyber Food", "Seoul"));
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurants;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurants.stream()
                .filter(r->r.getId().equals(id))
                .findFirst()
                //.get(); // 찾아진 것을 추출
                .orElse(null); // 찾을 수 없는 경우 null 이 나가도록 처리
    }
}
