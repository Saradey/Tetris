package com.goncharov.evgeny.tetris.base

import com.badlogic.gdx.Screen

abstract class BaseScreen : Screen {

    override fun show() = Unit

    override fun render(delta: Float) = Unit

    override fun resize(width: Int, height: Int) = Unit

    override fun pause() = Unit

    override fun resume() = Unit

    override fun hide() = Unit

    override fun dispose() = Unit
}
