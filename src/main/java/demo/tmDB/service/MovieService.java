package demo.tmDB.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import demo.tmDB.dto.MovieResponseDto;

/*
    - RestTemplate의 역할
    1. HTTP 요청 전송:
        지정된 URL에 HTTP 요청(GET, POST 등)을 보냅니다.

    2. 응답 데이터 처리:
        API로부터 받은 JSON 또는 XML 형식의 데이터를 지정된 클래스로 변환합니다.

    3. 매핑 기준:
        응답 데이터의 JSON 키 이름과 지정된 자바 클래스의 필드 이름을 매핑 기준으로 삼습니다.

 */
@Service
public class MovieService {
    @Value("${tmdb.key}")
    private String key;

    public MovieResponseDto moviePopularView() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + key + "&language=ko-KR&page=1";

        return restTemplate.getForObject(url, MovieResponseDto.class);
    }
}
