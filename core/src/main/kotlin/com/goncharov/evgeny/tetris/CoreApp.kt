package com.goncharov.evgeny.tetris

import com.badlogic.gdx.Game
import com.goncharov.evgeny.tetris.navigation.NavigationKey
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.screens.difficulty.DifficultyScreen
import com.goncharov.evgeny.tetris.screens.game.GameScreen
import com.goncharov.evgeny.tetris.screens.start.StartScreen
import com.goncharov.evgeny.tetris.utils.KoinLogger
import org.koin.core.context.startKoin
import com.goncharov.evgeny.tetris.service.locator.allModules
import com.goncharov.evgeny.tetris.service.locator.createCoreModule

class CoreApp : Game(), Navigator {

    override fun create() {
        initKoin()
        setScreen(StartScreen())
    }

    override fun navigation(key: NavigationKey) {
        when (key) {
            NavigationKey.StartScreenKey -> setScreen(StartScreen())
            NavigationKey.DifficultyScreenKey -> setScreen(DifficultyScreen())
            NavigationKey.GameScreenKey -> setScreen(GameScreen())
        }
    }

    private fun initKoin() {
        startKoin {
            logger(KoinLogger())
            modules(
                allModules.plus(
                    createCoreModule(this@CoreApp)
                ),
            )
        }
    }
}
