package com.goncharov.evgeny.tetris

import com.badlogic.gdx.Game
import com.goncharov.evgeny.tetris.screens.StartScreen

class App : Game() {

    override fun create() {
        setScreen(StartScreen())
    }
}
