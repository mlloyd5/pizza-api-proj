package com.mlloyd5.tupleapi.utlis

import kotlin.random.Random

class Randomizer {
    companion object {

        private val random = Random.Default

        private fun randomUser(): String {
            val adjectives = UserGenerator.Adjectives.values()
            val nouns = UserGenerator.Nouns.values()
            return adjectives[random.nextInt(0, adjectives.size)].toString() +
                    nouns[random.nextInt(0, nouns.size)].toString()
        }

        private fun randomToppingList(): List<String> {
            val toppings = Toppings.values()
            val maxToppings = random.nextInt(0, toppings.size)
            return if (maxToppings == 0) listOf("")
            else {
                List(maxToppings) { toppings[Random.nextInt(0, toppings.size)].toString() }
            }
        }

        fun randomTuples(count: Int): List<UserToppingTuple> {
            return List(count) { UserToppingTuple(randomUser(), randomToppingList()) }
        }
    }
}