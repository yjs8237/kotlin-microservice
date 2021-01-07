package com.microservice.kotlinproject

import com.microservice.kotlinproject.data.Customer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinprojectApplication {

    companion object {
        val initCustomer = arrayOf(Customer(1 , "jisang")
        , Customer(2 , "2") , Customer(3 , "3"))
    }

    @Bean
    fun customer(): HashMap<Int, Customer> {
        val hashMap : HashMap<Int , Customer> = mutableMapOf<Int, Customer>() as HashMap<Int, Customer>
        for (i in initCustomer.indices) {
            hashMap.put(i+1 , initCustomer[i])
        }
//        return ConcurrentHashMap<Int , Customer>(initCustomer.associateBy(Customer::id))
        return hashMap
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinprojectApplication>(*args)
}


