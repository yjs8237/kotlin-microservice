package com.microservice.kotlinproject.handler

import com.fasterxml.jackson.core.JsonParseException
import com.microservice.kotlinproject.data.ErrorResponse
import com.microservice.kotlinproject.exception.CustomerNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest: HttpServletRequest , exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("JSON Error" , exception.message?: "invalid json") , HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(CustomerNotFoundException::class)
    fun CustomerNotFoundException(servletRequest: HttpServletRequest , exception: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse("customer not found" , exception.message?: "customer not found") , HttpStatus.NOT_FOUND)
    }

}