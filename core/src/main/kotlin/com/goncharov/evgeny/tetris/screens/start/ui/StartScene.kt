package com.goncharov.evgeny.tetris.screens.start.ui

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.navigation.NavigationKey
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.BACKGROUND_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.PLAY_GAME_TEXT
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SOUND_CLICK_BUTTON_DESCRIPTOR
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR
import com.goncharov.evgeny.tetris.custom.actors.MainBackgroundDrawable
import com.goncharov.evgeny.tetris.custom.actors.TitleActor
import com.goncharov.evgeny.tetris.utils.addListenerKtx

class StartScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    private val navigator: Navigator
) : Stage(viewport, spriteBatch) {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val soundClickButton: Sound = resourceManager[SOUND_CLICK_BUTTON_DESCRIPTOR]
    private val root = Table()
    private val playButton = ImageTextButton(PLAY_GAME_TEXT, uiSkin)
    private val titleActor = TitleActor(uiSkin)

    init {
        initUi()
        initAction()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackgroundDrawable(uiSkin.getSprite(BACKGROUND_DRAWABLE_PATH)))
        root.add(titleActor)
            .row()
        playButton.addListenerKtx(::clickPlayButton)
        root.add(playButton)
            .expandX()
            .padTop(PLAY_BUTTON_TOP_PADDING)
            .padBottom(TOP_MARGIN_TITLE)
        addActor(root)
    }

    private fun clickPlayButton() {
        soundClickButton.play()
        navigator.navigation(NavigationKey.DifficultyScreenKey)
    }

    private fun initAction() {
        titleActor.initActions()
    }

    private companion object {
        const val PLAY_BUTTON_TOP_PADDING = 46f
        const val TOP_MARGIN_TITLE = 96f
    }
}
