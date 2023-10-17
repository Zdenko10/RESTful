package zdenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zdenko.dto.MovieDTO;
import zdenko.entity.filter.MovieFilter;
import zdenko.service.MovieService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping({"/genres", "/genres/"})
        public String[] getGenres() {
            return new String[] {"sci-fi", "adventure", "action", "romantic", "animated", "comedy"};
    }

    @PostMapping({"/movies", "/movies/"})
        public MovieDTO addMovie(@RequestBody MovieDTO movieDTO) {
            return movieService.addMovie(movieDTO);
    }

    @GetMapping({"/movies", "/movies/"})
        public List<MovieDTO> getAllMovies(MovieFilter movieFilter) {
            return movieService.getAllMovies(movieFilter);
    }

    @GetMapping({"/movies/{id}", "/movies/{id}/"})
        public MovieDTO getMovie(@PathVariable Long id) {
            return movieService.getMovie(id);
    }

    @PutMapping({"/movies/{id}", "/movies/{id}/"})
        public MovieDTO editMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
            return movieService.editMovie(id, movieDTO);
    }

    @DeleteMapping({"/movies/{id}", "/movies/{id}/"})
        public MovieDTO removeMovie(@PathVariable Long id) {
            return movieService.removeMovie(id);
    }

}
