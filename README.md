# koin

## Install

在Module gradle中宣告`koin`相關 dependencies implementation

```
dependencies {
        .
        .
        .
    implementation "org.koin:koin-android:1.0.0"
    implementation "org.koin:koin-android-scope:1.0.0"

        .
        .
        .
}
```

## use

```
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,listOf(module))

    }
}

val module = module {
    single {
        Cat()
    }
}

```

```
class MainActivity : AppCompatActivity() {

    private val creature:Dog by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dog: Dog by inject()
        // val dog:Dog = get()
        
        Log.d("test", "dog: ${dog.shout()}")
    }
}
```

ps. `by inject()` 或 `get()`都可以取得注入物件

## Commit

### startKoin()

指定注入 ModuleDefinition。允許注入多個

```
startKoin(this,listOf(moduleA, moduleB, moduleC, ...))
```

### module

指定要注入Object。 一個module只允許指定單一Object，如果想要注入多個物件則需要建立多個module

```
module {
    single {
        Dog()
    }
 }
```

或

```
module {
    factory {
        Dog()
    }
}
```

### get()

自動轉換成需要的型別，自動轉換成需要的型別dependency。

```
val dog:Dog = get()
```

### by inject()

做 lazy loading取得dependency

```
val dog: Dog by inject()
```

### factory vs single

***single:***  只有在第一次呼叫時才會New，之後到都會拿到同一個物件。

***factory:*** 每次呼叫時都New新物件。
