package tw.nolions.acguy.koin.model

class Dog : Creature {

    override fun name(): String {
        return "Dog"
    }

    override fun shout(): String {
        return "Woof"
    }
}