package com.microservice.kotlinproject.controller

import com.microservice.kotlinproject.service.HomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @Autowired
    private lateinit var homeService: HomeService


    @GetMapping("/")
    @ResponseBody
    fun home(): String {
        return "Hello World"
    }

    @GetMapping("/{name}")
    @ResponseBody
    fun name(@PathVariable name: String): String {
        return homeService.helloWorld(name)
    }


}