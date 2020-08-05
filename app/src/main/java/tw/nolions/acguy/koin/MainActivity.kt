package tw.nolions.acguy.koin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import tw.nolions.acguy.koin.model.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDog()
        injectCat()
        injectCreature(CreatureType.DOG)

        val cat: Cat = get()
        val user: User = get { parametersOf("John", cat) }
        Log.d("test", "my name is ${user.name}, i have a ${user.petType()}.")
    }

    private fun injectDog() {
        val dog: Dog by inject()

        Log.d("test", "Dog name: ${dog.name()}")
        Log.d("test", "Dog shout: ${dog.shout()}")
    }

    private fun injectCat() {
        val cat: Cat = get()

        Log.d("test", "Cat name: ${cat.name()}")
        Log.d("test", "Cat shout: ${cat.shout()}")
    }

    private fun injectCreature(type: CreatureType) {
        val creature: Creature = get { parametersOf(type) }

        Log.d("test", "Creature name: ${creature.name()}")
        Log.d("test", "Creature shout: ${creature.shout()}")
    }
}