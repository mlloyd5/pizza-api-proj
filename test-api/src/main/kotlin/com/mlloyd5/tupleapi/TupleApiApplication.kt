package com.mlloyd5.tupleapi

import com.mlloyd5.tupleapi.utlis.Randomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TupleApiApplication

fun main(args: Array<String>) {
	runApplication<TupleApiApplication>(*args)
}

@RestController
class MessageController {
	@GetMapping("/generateToppings")
	fun index(@RequestParam("count") count: Int) = Randomizer.randomTuples(count)
}