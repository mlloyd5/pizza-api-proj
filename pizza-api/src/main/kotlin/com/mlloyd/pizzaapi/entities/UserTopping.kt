package com.mlloyd.pizzaapi.entities

import javax.persistence.*

@Entity
@Table(name = "user_toppings")
open class UserTopping {
    @EmbeddedId
    open var id: UserToppingId? = null

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    open var user: User? = null

    @MapsId("toppingId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topping_id", nullable = false)
    open var topping: Topping? = null
}