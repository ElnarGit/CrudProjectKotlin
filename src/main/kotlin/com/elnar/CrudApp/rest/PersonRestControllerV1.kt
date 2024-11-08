package com.elnar.CrudApp.rest

import com.elnar.CrudApp.dto.PersonDto
import com.elnar.CrudApp.exception.NotFoundException
import com.elnar.CrudApp.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/people")
class PersonRestControllerV1(private val personService: PersonService) {

    @GetMapping
    fun getPeople() : List<PersonDto> = personService.getAllPeople()

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: Long): ResponseEntity<PersonDto> {
        val person = personService.getByIdPerson(id)
        return ResponseEntity.ok(person)
    }

    @PostMapping
    fun createPerson(@RequestBody personDto: PersonDto) : ResponseEntity<PersonDto>{
        val createPerson = personService.createPerson(personDto)
        return ResponseEntity.ok(createPerson)
    }

    @DeleteMapping("/{id}")
    fun deletePersonById(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        return try {
            personService.deletePerson(id)
            ResponseEntity.ok(mapOf("message" to "Person with ID $id has been successfully deleted"))
        } catch (e: NotFoundException) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("error" to (e.message ?: "Unknown error")))
        }
    }
}