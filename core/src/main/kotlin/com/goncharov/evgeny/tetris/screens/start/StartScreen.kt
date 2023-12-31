package com.goncharov.evgeny.tetris.screens.start

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.start.ui.StartScene
import com.goncharov.evgeny.tetris.utils.clearScreen
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.component.inject
import org.koin.core.scope.Scope

class StartScreen : ScreenAdapter(), KoinScopeComponent {

    override val scope: Scope = createScope()
    private val uiViewPort: FitViewport by inject()
    private val startScene: StartScene by inject()
    private val resourceManager: ResourceManager by inject()

    override fun show() {
        resourceManager.loadedAllResources()
        Gdx.input.inputProcessor = startScene
    }

    override fun render(delta: Float) {
        clearScreen()
        startScene.act()
        startScene.draw()
    }

    override fun resize(width: Int, height: Int) {
        uiViewPort.update(width, height, true)
    }

    override fun hide() {
        dispose()
    }

    override fun dispose() {
        Gdx.input.inputProcessor = null
        startScene.dispose()
        if (scope.isNotClosed()) {
            scope.close()
        }
    }
}
