package com.elnar.CrudApp.repository

import com.elnar.CrudApp.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long>