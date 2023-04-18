package com.mlloyd.pizzaapi.entities

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class UserToppingId : Serializable {
    @Column(name = "user_id", nullable = false)
    open var userId: Int? = null

    @Column(name = "topping_id", nullable = false)
    open var toppingId: Int? = null
    override fun hashCode(): Int = Objects.hash(userId, toppingId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as UserToppingId

        return userId == other.userId &&
                toppingId == other.toppingId
    }

    companion object {
        private const val serialVersionUID = -8646702750906870326L
    }
}