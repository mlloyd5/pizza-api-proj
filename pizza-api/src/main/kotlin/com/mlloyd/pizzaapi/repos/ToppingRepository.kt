package com.mlloyd.pizzaapi.repos;

import com.mlloyd.pizzaapi.entities.Topping
import org.springframework.data.repository.CrudRepository

interface ToppingRepository : CrudRepository<Topping, Int> {
    fun findByToppingName(toppingName: String): Iterable<Topping>
}