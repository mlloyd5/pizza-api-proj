package com.mlloyd.pizzaapi.controller

import com.mlloyd.pizzaapi.entities.Topping
import com.mlloyd.pizzaapi.entities.User
import com.mlloyd.pizzaapi.repos.ToppingRepository
import com.mlloyd.pizzaapi.repos.UserRepository
import com.mlloyd.pizzaapi.repos.UserToppingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {
    @Autowired
    lateinit var repository: UserRepository
    @Autowired
    lateinit var toppingRepository: ToppingRepository
    @Autowired
    lateinit var userToppingRepository: UserToppingRepository

    @RequestMapping("/findAll")
    fun findAll() = repository.findAll()

    @RequestMapping("findByUserName/{userName}")
    fun findByUserName(@PathVariable userName: String)
            = repository.findByUserName(userName)

    @RequestMapping("findByToppingName/{toppingName}")
    fun findByToppingName(@PathVariable toppingName: String)
        = toppingRepository.findByToppingName(toppingName)

    @RequestMapping("countToppings/{toppingName}")
    fun countDistinctByToppingName(@PathVariable toppingName: String)
        = userToppingRepository.countDistinctByToppingName(toppingName)

    @RequestMapping("topToppings")
    fun topToppings() = userToppingRepository.topToppings()

}