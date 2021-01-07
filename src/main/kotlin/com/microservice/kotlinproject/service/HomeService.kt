package com.microservice.kotlinproject.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HomeService : HomServiceInt {


    fun getString(name: String): String {
        return "Hello ${name}"
    }

    override fun helloWorld(name: String): String {
        //logger.info(name)
        return "Hello Interface ${name}"
    }
}