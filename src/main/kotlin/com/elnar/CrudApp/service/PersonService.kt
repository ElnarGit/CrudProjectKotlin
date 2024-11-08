package com.elnar.CrudApp.service

import com.elnar.CrudApp.dto.PersonDto


interface PersonService {
    fun getAllPeople(): List<PersonDto>
    fun getByIdPerson(id : Long) : PersonDto?
    fun createPerson(person: PersonDto) : PersonDto
    fun deletePerson(id: Long)
}