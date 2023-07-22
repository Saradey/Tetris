package com.goncharov.evgeny.tetris.screens.game.ui

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.custom.actors.MainBackground
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.BACKGROUND_LINE_UI_PATH
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR
import org.koin.core.component.KoinComponent

class GameScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    private val navigator: Navigator
) : Stage(viewport, spriteBatch), KoinComponent {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val root = Table()

    init {
        initUi()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackground(uiSkin.getSprite(BACKGROUND_LINE_UI_PATH)))
        addActor(root)
    }
}
