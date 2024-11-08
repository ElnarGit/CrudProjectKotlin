package com.elnar.TestProject3.util

import com.elnar.CrudApp.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException) : ResponseEntity<Any>{
        val response = mapOf(
            "timestamp" to System.currentTimeMillis(),
            "status" to HttpStatus.NOT_FOUND.value(),
            "error" to "Not Found",
            "message" to exception.message,
            "errorCode" to exception.errorCode
        )
        return ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}