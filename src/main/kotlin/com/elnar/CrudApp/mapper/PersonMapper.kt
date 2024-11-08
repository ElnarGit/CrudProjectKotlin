package com.elnar.CrudApp.mapper

import com.elnar.CrudApp.dto.PersonDto
import com.elnar.CrudApp.entity.Person

class PersonMapper {

    fun toDto(person: Person): PersonDto {
        return PersonDto(
            id = person.id,
            name = person.name,
            age = person.age,
            )
    }

    fun toEntity(personDto: PersonDto): Person {
        return Person(
            id = personDto.id,
            name = personDto.name,
            age = personDto.age,
            )
    }
}

