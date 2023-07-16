package com.goncharov.evgeny.tetris

import com.badlogic.gdx.Game
import com.goncharov.evgeny.tetris.screens.StartScreen
import com.goncharov.evgeny.tetris.utils.KoinLogger
import org.koin.core.context.startKoin


class CoreApp : Game() {

    override fun create() {
        setScreen(StartScreen())
    }

    private fun initKoin() {
        startKoin {
            logger(KoinLogger())
        }
    }
}
