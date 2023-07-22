package com.goncharov.evgeny.tetris.screens.difficulty.ui

import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.custom.actors.MainBackground
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.BACKGROUND_LINE_UI_PATH
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SOUND_CLICK_BUTTON_DESCRIPTOR
import com.goncharov.evgeny.tetris.resources.TITLE_SHAPE_PATH
import com.goncharov.evgeny.tetris.resources.TITLE_UI_PATH
import com.goncharov.evgeny.tetris.resources.UI_ASSET_DESCRIPTOR
import com.goncharov.evgeny.tetris.screens.start.ui.StartScene

class DifficultyScene(
    viewport: Viewport,
    spriteBatch: SpriteBatch,
    resourceManager: ResourceManager,
    private val navigator: Navigator
) : Stage(viewport, spriteBatch) {

    private val uiSkin: Skin = resourceManager[UI_ASSET_DESCRIPTOR]
    private val soundClickButton: Sound = resourceManager[SOUND_CLICK_BUTTON_DESCRIPTOR]
    private val root = Table()
    private val titleDot = Image(uiSkin, TITLE_SHAPE_PATH)
    private val title = Image(uiSkin, TITLE_UI_PATH)

    init {
        initUi()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackground(uiSkin.getSprite(BACKGROUND_LINE_UI_PATH)))
        root.add(titleDot).padLeft(LEFT_MARGIN_TITLE_DOT).padBottom(MOVE_TITLE_DOT_POSITION).row()
        root.add(title).expandX().row()
        addActor(root)
    }

    private companion object {
        const val LEFT_MARGIN_TITLE_DOT = 84f
        const val MOVE_TITLE_DOT_POSITION = -20f
    }
}
