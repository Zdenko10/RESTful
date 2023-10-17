package zdenko.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import zdenko.dto.MovieDTO;
import zdenko.entity.MovieEntity;
import zdenko.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "directorID", source = "director.id")
    @Mapping(target = "actorIDs", expression = "java(getActorIds(source))")
    MovieDTO toDTO(MovieEntity source);

    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "director", ignore = true)
    MovieEntity toEntity(MovieDTO source);

    @Mapping(target = "dateAdded", ignore = true)
    @Mapping(target = "actors", ignore = true)
    @Mapping(target = "director", ignore = true)
    MovieEntity updateEntity(MovieDTO source, @MappingTarget MovieEntity target);

    default List<Long> getActorIds(MovieEntity source) {
        List<Long> result = new ArrayList<>();
        for (PersonEntity person : source.getActors()) {
            result.add(person.getId());
        }
        return result;
    }

}

