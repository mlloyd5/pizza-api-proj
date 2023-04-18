package com.mlloyd.pizzaapi.entities

import javax.persistence.*

@Entity
@Table(name = "users")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    open var id: Int? = null

    @Column(name = "username", nullable = false, length = 128)
    open var userName: String? = null

    @ManyToMany
    @JoinTable(name = "user_toppings",
            joinColumns = [JoinColumn(name = "user_id")],
            inverseJoinColumns = [JoinColumn(name = "topping_id")])
    open var toppings : MutableSet<Topping> = mutableSetOf()
}