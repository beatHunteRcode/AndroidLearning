package com.androidlearning.patterns.builder

class Creature private constructor(
    val name: String,
    val age: Int,
    val arms: Int,
    val legs: Int,
    val voice: String
) {

    class Builder() {

        private var name: String = ""
        private var age: Int = 0
        private var arms: Int = 0
        private var legs: Int = 0
        private var voice = ""

        constructor(creature: Creature) : this() {
            this.name = creature.name
            this.age = creature.age
            this.arms = creature.arms
            this.legs = creature.legs
            this.voice = creature.voice
        }

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun age(age: Int): Builder {
            this.age = age
            return this
        }

        fun arms(arms: Int): Builder {
            this.arms = arms
            return this
        }

        fun legs(legs: Int): Builder {
            this.legs = legs
            return this
        }

        fun voice(voice: String): Builder {
            this.voice = voice
            return this
        }

        fun build(): Creature = Creature(name, age, arms, legs, voice)
    }

}