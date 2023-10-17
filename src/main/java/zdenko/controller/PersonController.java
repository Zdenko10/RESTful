package zdenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;
import zdenko.constant.RoleType;
import zdenko.dto.PersonDTO;
import zdenko.service.PersonService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping({"/people/", "/people"})
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @GetMapping(value = {"/actors", "/actors/"})
    public List<PersonDTO> getActors(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return personService.getPeople(RoleType.actor, limit);
    }

    @GetMapping(value = {"/directors", "/directors/"})
    public List<PersonDTO> getDirectors(@RequestParam(required = false, defaultValue = Integer.MAX_VALUE + "") int limit) {
        return personService.getPeople(RoleType.director, limit);
    }

    @GetMapping("/people/{personId}")
    public PersonDTO getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

    @PutMapping({"/people/{personId}", "/people/{personId}/"})
    public PersonDTO editPerson(@PathVariable Long personId, @RequestBody PersonDTO personDTO) throws NotFoundException {
        return personService.editPerson(personId, personDTO);
    }

    @DeleteMapping({"/people/{personId}", "/people/{personId}/"})
    public PersonDTO deletePerson(@PathVariable Long personId) {
        return personService.removePerson(personId);
    }

}
