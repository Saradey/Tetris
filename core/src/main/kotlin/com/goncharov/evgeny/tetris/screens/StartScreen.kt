package com.goncharov.evgeny.tetris.screens

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.service.locator.qualifiers.UiViewPort
import org.koin.java.KoinJavaComponent.get

class StartScreen : ScreenAdapter() {

    private val uiViewPort: FitViewport  = get(FitViewport::class.java, UiViewPort)

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
