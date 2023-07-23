package com.goncharov.evgeny.tetris.screens.difficulty.ui

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.custom.actors.DifficultyLevelActor
import com.goncharov.evgeny.tetris.custom.actors.MainBackgroundDrawable
import com.goncharov.evgeny.tetris.navigation.NavigationKey
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.repositories.DifficultyRepository
import com.goncharov.evgeny.tetris.resources.BACKGROUND_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.DIFFICULTY_INFO_TEXT
import com.goncharov.evgeny.tetris.resources.OK_TEXT
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SOUND_CLICK_BUTTON_DESCRIPTOR
import com.goncharov.evgeny.tetris.resources.TITLE_SHAPE_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.TITLE_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR
import com.goncharov.evgeny.tetris.utils.addListenerKtx

class DifficultyScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    private val navigator: Navigator,
    private val difficultyRepository: DifficultyRepository
) : Stage(viewport, spriteBatch) {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val soundClickButton: Sound = resourceManager[SOUND_CLICK_BUTTON_DESCRIPTOR]
    private val root = Table()
    private val titleDot = Image(uiSkin, TITLE_SHAPE_DRAWABLE_PATH)
    private val title = Image(uiSkin, TITLE_DRAWABLE_PATH)
    private val difficultyInfoLabel = Label(DIFFICULTY_INFO_TEXT, uiSkin)
    private val difficultyLevelActor = DifficultyLevelActor(uiSkin)
    private val gameStartTextButton = ImageTextButton(OK_TEXT, uiSkin)

    init {
        initUi()
        initListeners()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackgroundDrawable(uiSkin.getSprite(BACKGROUND_DRAWABLE_PATH)))
        root.add(titleDot)
            .padLeft(LEFT_MARGIN_TITLE_DOT)
            .padBottom(MOVE_TITLE_DOT_POSITION)
            .row()
        root.add(title)
            .expandX()
            .row()
        root.add(difficultyInfoLabel)
            .padTop(PADDING_TOP_INFO_LABEL)
            .expandX()
            .row()
        root.add(difficultyLevelActor)
            .padTop(PADDING_TOP_DIFFICULTY_LEVEL)
            .expandX()
            .row()
        root.add(gameStartTextButton)
            .padTop(PADDING_TOP_START_BUTTON)
            .expandX()
            .row()
        addActor(root)
    }

    private fun initListeners() {
        difficultyLevelActor.initListenerDifficultyLevel { difficultyLevel ->
            soundClickButton.play()
            difficultyRepository.setDifficultyLvl(difficultyLevel)
        }
        gameStartTextButton.addListenerKtx(::clickStartGame)
    }

    private fun clickStartGame() {
        soundClickButton.play()
        navigator.navigation(NavigationKey.GameScreenKey)
    }

    private companion object {
        const val LEFT_MARGIN_TITLE_DOT = 84f
        const val MOVE_TITLE_DOT_POSITION = -20f
        const val PADDING_TOP_INFO_LABEL = 36f
        const val PADDING_TOP_DIFFICULTY_LEVEL = 14f
        const val PADDING_TOP_START_BUTTON = 24f
    }
}
