package com.mlloyd.pizzaapi.entities

import javax.persistence.*

@Entity
@Table(name = "toppings")
open class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topping_id", nullable = false)
    open var id: Int? = null

    @Column(name = "topping_name", nullable = false, length = 64)
    open var toppingName: String? = null
}