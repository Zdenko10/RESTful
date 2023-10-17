package zdenko.dto.mapper;

import org.mapstruct.Mapper;
import zdenko.dto.PersonDTO;
import zdenko.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity toEntity(PersonDTO personDTO);
    PersonDTO toDTO(PersonEntity personEntity);

}
