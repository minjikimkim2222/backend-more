package test.lion.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import test.lion.entity.Restaurant;
import test.lion.repository.RestaurantESRepository;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Service
public class CsvFileReaderService {

    @Autowired
    private ResourceLoader resourceLoader;
    //@Autowired private BookService bookService;
    // @Autowired private BookEsService bookEsService;
    @Autowired private RestaurantESRepository restaurantRepository;

    public void restaurantSeoulToElasticSearch() {
        try {
            Resource resource = resourceLoader.getResource("classpath:/static/data/서울맛집3.csv");
            try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                int count = 0;
                for (CSVRecord record: csvParser) {
                    String name = record.get("상호");
                    String intro = record.get("설명");
                    String imgSrc = record.get("img_src");
                    String infoJsonStr = record.get("업소정보");
                    String reviewJsonStr = record.get("리뷰");

                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        Map<String, Object> info = objectMapper.readValue(infoJsonStr, Map.class);
                        List<Map<String, Object>> reviews = objectMapper.readValue(reviewJsonStr, new TypeReference<>() {});

                        Restaurant restaurant = Restaurant.builder()
                                .name(name).intro(intro).imgSrc(imgSrc).info(info).reviews(reviews)
                                .build();
                        restaurantRepository.save(restaurant);

                        if (count++ % 100 == 0)
                            System.out.println("count = " + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
