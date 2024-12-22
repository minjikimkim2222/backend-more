package demo.tmDB.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.tmDB.dto.MovieResponseDto;
import demo.tmDB.service.MovieService;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/popular")
    public ResponseEntity<MovieResponseDto> getPopularViews(){
        MovieResponseDto movieResponseDto = movieService.moviePopularView();

        return ResponseEntity.ok(movieResponseDto);
    }
}
