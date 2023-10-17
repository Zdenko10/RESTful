package zdenko.service;

import zdenko.dto.MovieDTO;
import zdenko.entity.filter.MovieFilter;
import java.util.List;

public interface MovieService {
    MovieDTO addMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies(MovieFilter movieFilter);
    MovieDTO getMovie(Long id);
    MovieDTO editMovie(Long id, MovieDTO movieDTO);
    MovieDTO removeMovie(Long id);

}
