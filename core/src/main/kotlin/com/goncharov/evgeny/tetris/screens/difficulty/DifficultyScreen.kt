package com.goncharov.evgeny.tetris.screens.difficulty

import com.badlogic.gdx.ScreenAdapter
import com.goncharov.evgeny.tetris.screens.difficulty.ui.DifficultyScene
import com.goncharov.evgeny.tetris.utils.clearScreen
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class DifficultyScreen : ScreenAdapter(), KoinScopeComponent {

    override val scope: Scope = createScope()
    private val difficultyScene: DifficultyScene by inject()

    override fun show() {
        difficultyScene
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
