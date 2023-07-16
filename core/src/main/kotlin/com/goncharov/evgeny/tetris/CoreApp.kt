package com.goncharov.evgeny.tetris

import com.badlogic.gdx.Game
import com.goncharov.evgeny.tetris.navigation.NavigationKey
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.screens.StartScreen
import com.goncharov.evgeny.tetris.utils.KoinLogger
import org.koin.core.context.startKoin


class CoreApp : Game(), Navigator {

    override fun create() {
        setScreen(StartScreen())
    }

    override fun navigation(key: NavigationKey) {
        TODO("Not yet implemented")
    }

    private fun initKoin() {
        startKoin {
            logger(KoinLogger())
        }
    }
}
