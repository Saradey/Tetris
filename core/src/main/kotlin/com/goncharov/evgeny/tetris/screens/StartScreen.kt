package com.goncharov.evgeny.tetris.screens

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StartScreen : ScreenAdapter(), KoinComponent {

    private val uiViewPort: FitViewport by inject()

    override fun show() {

    }

    override fun render(delta: Float) {

    }

    override fun resize(width: Int, height: Int) {

    }

    override fun hide() {
        dispose()
    }

    override fun dispose() {

    }
}
