package com.mlloyd.pizzaapi.repos

import com.mlloyd.pizzaapi.entities.UserTopping
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface UserToppingRepository : CrudRepository<UserTopping, Long>{
    @Query("select count(distinct ut.user) from UserTopping ut JOIN Topping t ON t.id = ut.topping.id where t.toppingName = ?1")
    fun countDistinctByToppingName(toppingName: String): Long

    @Query("select new map(ut.topping.toppingName as toppingName,count(*) as toppingCount) " +
            "from UserTopping ut group by ut.topping.toppingName order by count(*) DESC")
    fun topToppings() : Iterable<Map<String, Long>>
}