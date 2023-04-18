package com.mlloyd.pizzaapi.repos

import com.mlloyd.pizzaapi.entities.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByUserName(userName: String): Iterable<User>
}