package com.goncharov.evgeny.tetris.screens.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.screens.game.ui.GameScene
import com.goncharov.evgeny.tetris.utils.clearScreen
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class GameScreen : ScreenAdapter(), KoinScopeComponent {

    override val scope: Scope = createScope()
    private val uiViewPort: FitViewport by inject()
    private val gameScene: GameScene by inject()

    override fun show() {
        Gdx.input.inputProcessor = gameScene
    }

    override fun render(delta: Float) {
        clearScreen()
        gameScene.act()
        gameScene.draw()
    }

    override fun resize(width: Int, height: Int) {
        uiViewPort.update(width, height, true)
    }

    override fun dispose() {
        Gdx.input.inputProcessor = null
        gameScene.dispose()
        if (scope.isNotClosed()) {
            scope.close()
        }
    }

    override fun hide() {
        dispose()
    }
}
