package com.goncharov.evgeny.tetris.screens.start

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.service.locator.qualifiers.UiViewPort
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class StartScreen : ScreenAdapter(), KoinComponent {

    private val uiViewPort: FitViewport by inject()

    override fun show() {
        uiViewPort
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
