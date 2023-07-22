package com.goncharov.evgeny.tetris.screens.difficulty

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.screens.difficulty.ui.DifficultyScene
import com.goncharov.evgeny.tetris.utils.clearScreen
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class DifficultyScreen : ScreenAdapter(), KoinScopeComponent {

    override val scope: Scope = createScope()
    private val difficultyScene: DifficultyScene by inject()
    private val uiViewPort: FitViewport by inject()

    override fun show() {
        Gdx.input.inputProcessor = difficultyScene
    }

    override fun render(delta: Float) {
        clearScreen()
        difficultyScene.act()
        difficultyScene.draw()
    }

    override fun resize(width: Int, height: Int) {
        uiViewPort.update(width, height, true)
    }

    override fun dispose() {
        Gdx.input.inputProcessor = null
        difficultyScene.dispose()
        if (scope.isNotClosed()) {
            scope.close()
        }
    }

    override fun hide() {
        dispose()
    }
}
