package zdenko.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import zdenko.dto.MovieDTO;
import zdenko.dto.mapper.MovieMapper;
import zdenko.entity.MovieEntity;
import zdenko.entity.filter.MovieFilter;
import zdenko.entity.repository.MovieRepository;
import zdenko.entity.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        MovieEntity movie = movieMapper.toEntity(movieDTO);
        movie.setActors(new ArrayList<>());
        for (Long actorId : movieDTO.getActorIDs()) {
            movie.getActors().add(personRepository.getReferenceById(actorId));
        }
        movie.setDirector(personRepository.getReferenceById(movieDTO.getDirectorID()));
        MovieEntity saved = movieRepository.save(movie);
        return movieMapper.toDTO(saved);
    }

    @Override
    public List<MovieDTO> getAllMovies(MovieFilter movieFilter) {
        List<MovieDTO> result = new ArrayList<>();
        for(MovieEntity movie : movieRepository.getFilteredMovies(movieFilter, PageRequest.of(0, movieFilter.getLimit()))) {
            result.add(movieMapper.toDTO(movie));
        }
        return result;
    }

    @Override
    public MovieDTO getMovie(Long id) {
        MovieEntity movie = movieRepository.getReferenceById(id);
        return movieMapper.toDTO(movie);
    }

    @Override
    public MovieDTO editMovie(Long id, MovieDTO movieDTO) {
        movieDTO.setId(id);
        MovieEntity entity = movieRepository.getReferenceById(id);
        movieMapper.updateEntity(movieDTO, entity);

        entity.setActors(new ArrayList<>());
        for(Long actorId : movieDTO.getActorIDs()){
            entity.getActors().add(personRepository.getReferenceById(actorId));
        }
        entity.setDirector(personRepository.getReferenceById(movieDTO.getDirectorID()));
        MovieEntity saved = movieRepository.save(entity);
        return movieMapper.toDTO(saved);
    }

    @Override
    public MovieDTO removeMovie(Long id) {
        MovieEntity entity = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        MovieDTO model = movieMapper.toDTO(entity);
        movieRepository.delete(entity);
        return model;
    }

}

