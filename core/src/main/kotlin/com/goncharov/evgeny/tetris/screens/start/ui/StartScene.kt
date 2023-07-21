package com.goncharov.evgeny.tetris.screens.start.ui

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.resources.BACKGROUND_LINE_UI_PATH
import com.goncharov.evgeny.tetris.resources.PLAY_GAME_TEXT
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SOUND_CLICK_BUTTON_DESCRIPTOR
import com.goncharov.evgeny.tetris.resources.TITLE_SHAPE_PATH
import com.goncharov.evgeny.tetris.resources.TITLE_UI_PATH
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR
import com.goncharov.evgeny.tetris.ui.MainBackground
import com.goncharov.evgeny.tetris.utils.addListenerKtx

class StartScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager
) : Stage(viewport, spriteBatch) {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val soundClickButton: Sound = resourceManager[SOUND_CLICK_BUTTON_DESCRIPTOR]

    private val root = Table()
    private val title = Image(uiSkin, TITLE_UI_PATH)
    private val playButton = ImageTextButton(PLAY_GAME_TEXT, uiSkin)
    private val titleDot = Image(uiSkin, TITLE_SHAPE_PATH)

    init {
        initUi()
        initAction()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackground(uiSkin.getSprite(BACKGROUND_LINE_UI_PATH)))
        root.add(titleDot).padLeft(LEFT_MARGIN_TITLE_DOT).padBottom(-12f).row()
        root.add(title).expandX().row()
        playButton.addListenerKtx(::clickPlayButton)
        root.add(playButton).expandX().padTop(PLAY_BUTTON_TOP_PADDING)
        addActor(root)
    }

    private fun clickPlayButton() {
        soundClickButton.play()
    }

    private fun initAction() {

    }

    private companion object {
        const val PLAY_BUTTON_TOP_PADDING = 80f
        const val LEFT_MARGIN_TITLE_DOT = 84f
    }
}
