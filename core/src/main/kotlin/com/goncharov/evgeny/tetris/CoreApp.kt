package com.goncharov.evgeny.tetris

import com.badlogic.gdx.Game
import com.goncharov.evgeny.tetris.navigation.NavigationKey
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.start.StartScreen
import com.goncharov.evgeny.tetris.utils.KoinLogger
import org.koin.core.context.startKoin
import com.goncharov.evgeny.tetris.service.locator.allModules
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CoreApp : Game(), Navigator, KoinComponent {

    private val resourceManager: ResourceManager by inject()

    override fun create() {
        initKoin()
        resourceManager
        setScreen(StartScreen())
    }

    override fun navigation(key: NavigationKey) {
        //TODO
    }

    private fun initKoin() {
        startKoin {
            logger(KoinLogger())
            modules(allModules)
        }
    }
}
