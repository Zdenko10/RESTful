package zdenko.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zdenko.constant.RoleType;
import zdenko.dto.PersonDTO;
import zdenko.dto.mapper.PersonMapper;
import zdenko.entity.PersonEntity;
import zdenko.entity.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO) {
        PersonEntity entity = personMapper.toEntity(personDTO);
        PersonEntity savedEntity = personRepository.save(entity);
        return personMapper.toDTO(savedEntity);
    }

    @Override
    public List<PersonDTO> getPeople(RoleType roleType, int limit) {
        List<PersonEntity> personEntities = personRepository.getAllByRole(roleType, limit);

        List<PersonDTO> result = new ArrayList<>();
        for (PersonEntity e : personEntities) {
            result.add(personMapper.toDTO(e));
        }
        return result;
    }

    @Override
    public PersonDTO getPerson(Long personId) {
        PersonEntity person = personRepository.getReferenceById(personId);
        return personMapper.toDTO(person);
    }

    @Override
    public PersonDTO editPerson(Long personId, PersonDTO personDTO) {
        if (!personRepository.existsById(personId)) {
            throw new EntityNotFoundException("Person with id " + personId + " wasn't found in the database.");
        }
        PersonEntity entity = personMapper.toEntity(personDTO);
        entity.setId(personId);
        PersonEntity saved = personRepository.save(entity);
        return personMapper.toDTO(saved);
    }

    @Override
    public PersonDTO removePerson(Long personId) {
        PersonEntity person = personRepository.findById(personId).orElseThrow(EntityNotFoundException::new);
        PersonDTO model = personMapper.toDTO(person);
        personRepository.delete(person);
        return model;
    }

}
