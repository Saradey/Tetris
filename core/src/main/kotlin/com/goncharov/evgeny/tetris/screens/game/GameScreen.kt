package com.goncharov.evgeny.tetris.screens.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.utils.clearScreen
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class GameScreen : ScreenAdapter(), KoinScopeComponent {

    override val scope: Scope = createScope()
    private val uiViewPort: FitViewport by inject()

    override fun show() {

    }

    override fun render(delta: Float) {
        clearScreen()
    }

    override fun resize(width: Int, height: Int) {
        uiViewPort.update(width, height, true)
    }

    override fun dispose() {
        Gdx.input.inputProcessor = null
        if (scope.isNotClosed()) {
            scope.close()
        }
    }

    override fun hide() {
        dispose()
    }
}
