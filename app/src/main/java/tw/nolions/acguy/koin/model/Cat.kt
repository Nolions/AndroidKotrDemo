package tw.nolions.acguy.koin.model

class Cat : Creature {
    override fun name(): String {
        return "Cat"
    }

    override fun shout(): String {
        return "Nya"
    }
}