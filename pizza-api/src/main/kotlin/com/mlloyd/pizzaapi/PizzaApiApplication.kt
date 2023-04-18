package com.mlloyd.pizzaapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class PizzaApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(PizzaApiApplication::class.java, *args)
}
