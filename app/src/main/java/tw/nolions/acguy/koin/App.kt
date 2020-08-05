package tw.nolions.acguy.koin

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module
import tw.nolions.acguy.koin.model.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(dogModule, catModule, creatureModule, userModule))
    }
}

val dogModule = module {
    single {
        Dog()
    }
}

val catModule = module {
    single {
        Cat()
    }
}

val creatureModule = module {
    single { (type: CreatureType) ->
        when (type) {
            CreatureType.CAT -> Cat()
            CreatureType.DOG -> Dog()
            else -> Dog()
        }
    }
}

val userModule = module {
    single { (name: String, pet: Creature) ->
        User(name, pet)
    }
}