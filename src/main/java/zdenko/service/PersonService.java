package zdenko.service;

import org.webjars.NotFoundException;
import zdenko.constant.RoleType;
import zdenko.dto.PersonDTO;
import java.util.List;

public interface PersonService {
    PersonDTO addPerson(PersonDTO personDTO);
    List<PersonDTO> getPeople(RoleType roleType, int limit);
    PersonDTO getPerson(Long personId);
    PersonDTO editPerson(Long personId, PersonDTO personDTO) throws NotFoundException;
    PersonDTO removePerson(Long personId);

}
