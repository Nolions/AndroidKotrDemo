package tw.nolions.acguy.koin.model

interface Creature {
    fun name(): String

    fun shout(): String
}

enum class CreatureType {
    CAT, DOG
}