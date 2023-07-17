package com.goncharov.evgeny.tetris.screens.start

import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.screens.start.ui.StartScene
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
        uiViewPort
        startScene
    }

    override fun render(delta: Float) {

    }

    override fun resize(width: Int, height: Int) {

    }

    override fun hide() {
        dispose()
    }

    override fun dispose() {
        if (scope.isNotClosed()) {
            scope.close()
        }
    }
}
