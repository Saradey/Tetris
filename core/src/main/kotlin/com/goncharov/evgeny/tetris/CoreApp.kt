package com.goncharov.evgeny.tetris

import com.badlogic.gdx.Game
import com.goncharov.evgeny.tetris.screens.StartScreen

class CoreApp : Game() {

    override fun create() {
        setScreen(StartScreen())
    }
}
