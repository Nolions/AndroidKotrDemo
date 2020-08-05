package tw.nolions.acguy.koin.model

class User(val name: String, val pet: Creature) {

    fun name(): String {
        return name
    }

    fun petType(): String {
        return pet.name()
    }
}