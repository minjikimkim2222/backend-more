package test.lion.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import test.lion.entity.Restaurant;

public interface RestaurantESRepository extends ElasticsearchRepository<Restaurant, String> {
}
