package com.elnar.CrudApp.service.impl

import com.elnar.CrudApp.dto.PersonDto
import com.elnar.CrudApp.exception.NotFoundException
import com.elnar.CrudApp.mapper.PersonMapper
import com.elnar.CrudApp.repository.PersonRepository
import com.elnar.CrudApp.service.PersonService
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {

    private val personMapper = PersonMapper()

    override fun getAllPeople(): List<PersonDto> {
        return personRepository.findAll().map { personMapper.toDto(it) }
    }

    override fun getByIdPerson(id: Long): PersonDto? {
        return personRepository.findById(id).orElseThrow{
            NotFoundException("Person with ID $id does not exist", "PERSON_NOT_FOUND") }
            .let { personMapper.toDto(it) }
    }

    override fun createPerson(personDto: PersonDto): PersonDto {
        val person = personMapper.toEntity(personDto)
        val savedPerson = personRepository.save(person)

        return personMapper.toDto(savedPerson)
    }

    override fun deletePerson(id: Long) {
        if (!personRepository.existsById(id)) {
            throw NotFoundException("Person with ID $id does not exist", "PERSON_NOT_FOUND")
        }
        personRepository.deleteById(id)
    }
}