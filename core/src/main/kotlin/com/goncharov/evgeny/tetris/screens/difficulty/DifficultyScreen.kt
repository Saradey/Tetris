package com.goncharov.evgeny.tetris.screens.difficulty

import com.badlogic.gdx.ScreenAdapter
import com.goncharov.evgeny.tetris.utils.clearScreen

class DifficultyScreen : ScreenAdapter() {

    override fun show() {

    }

    override fun render(delta: Float) {
        clearScreen()
    }

    override fun resize(width: Int, height: Int) {

    }

    override fun hide() {
        dispose()
    }

    override fun dispose() {

    }
}
