package test.lion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.lion.service.CsvFileReaderService;

@Controller
@RequestMapping("/restaurant")
@RequiredArgsConstructor
public class RestaurantESController {
    private final CsvFileReaderService csvFileReaderService;

    @GetMapping("/init")
    @ResponseBody
    public String init(){
        csvFileReaderService.restaurantSeoulToElasticSearch();

        return "<h1>Done</h1>";
    }
}
