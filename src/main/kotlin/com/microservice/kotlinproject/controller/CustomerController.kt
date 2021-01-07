package com.microservice.kotlinproject.controller

import com.microservice.kotlinproject.data.ApiResonse
import com.microservice.kotlinproject.data.Customer
import com.microservice.kotlinproject.exception.CustomerNotFoundException
import com.microservice.kotlinproject.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customers")
    fun getCustomers(): ResponseEntity<List<Customer?>> {
        return ResponseEntity(customerService.getCustomers() , HttpStatus.OK)
    }

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int): ResponseEntity<ApiResonse> {
        val customer = customerService.getCustomer(id) ?: throw CustomerNotFoundException("customer id ${id} is not found")
        val status = customer?.let { HttpStatus.OK } ?: HttpStatus.NOT_FOUND
        val code = customer?.let { 0 } ?: -1
        val message = customer?.let { "success" } ?: "NOT_FOUND"
        return ResponseEntity(ApiResonse(code , message , customer) , status)
    }

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Unit> {
        customerService.createCustomer(customer)
        return ResponseEntity(Unit , HttpStatus.OK)
    }

    @PutMapping("/customer/{id}")
    fun updateCustomer(@PathVariable id: Int , @RequestBody customer: Customer): ResponseEntity<Customer> {
        var status = HttpStatus.NOT_FOUND
        var updatedCustomer : Customer? = null
        if(customerService.getCustomer(id) != null) {
            updatedCustomer = customerService.updateCustomer(id , customer)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity(updatedCustomer , status)
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit> {
        customerService.deleteCustomer(id)
        return ResponseEntity(null , HttpStatus.OK)
    }



}