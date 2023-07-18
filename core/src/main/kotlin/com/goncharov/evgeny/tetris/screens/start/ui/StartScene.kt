package com.goncharov.evgeny.tetris.screens.start.ui

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.resources.BACKGROUND_LINE
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SOUND_CLICK_BUTTON_DESCRIPTOR
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR
import com.goncharov.evgeny.tetris.ui.MainBackground

class StartScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager
) : Stage(viewport, spriteBatch) {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val soundClickButton: Sound = resourceManager[SOUND_CLICK_BUTTON_DESCRIPTOR]

    init {
        initUi()
        initAction()
    }

    private fun initUi() {
        val root = Table()
        root.setFillParent(true)
        root.background(MainBackground(uiSkin.getSprite(BACKGROUND_LINE)))
        addActor(root)
    }

    private fun initAction() {

    }
}
