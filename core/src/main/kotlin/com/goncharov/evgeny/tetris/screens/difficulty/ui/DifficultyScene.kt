package com.goncharov.evgeny.tetris.screens.difficulty.ui

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SOUND_CLICK_BUTTON_DESCRIPTOR
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR

class DifficultyScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    private val navigator: Navigator
) : Stage(viewport, spriteBatch) {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val soundClickButton: Sound = resourceManager[SOUND_CLICK_BUTTON_DESCRIPTOR]

    init {
        initUi()
    }

    private fun initUi() {

    }
}
