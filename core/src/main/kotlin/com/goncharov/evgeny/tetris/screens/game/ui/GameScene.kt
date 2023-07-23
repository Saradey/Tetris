package com.goncharov.evgeny.tetris.screens.game.ui

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.custom.actors.GameInfoActor
import com.goncharov.evgeny.tetris.custom.actors.MainBackgroundDrawable
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.BACKGROUND_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.LEVEL_START_SCORE
import com.goncharov.evgeny.tetris.resources.LEVEL_TEXT
import com.goncharov.evgeny.tetris.resources.START_SCORE_TEXT
import com.goncharov.evgeny.tetris.resources.LINES_TEXT
import com.goncharov.evgeny.tetris.resources.RESPAWN_GROUND_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.ResourceManager
import com.goncharov.evgeny.tetris.resources.SCORE_TEXT
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
    private val backgroundSpawnInfo = Image(uiSkin, RESPAWN_GROUND_DRAWABLE_PATH)
    private val lvlGameInfo = GameInfoActor(uiSkin, LEVEL_TEXT, LEVEL_START_SCORE)
    private val linesInfo = GameInfoActor(uiSkin, LINES_TEXT, START_SCORE_TEXT)
    private val scoreInfo = GameInfoActor(uiSkin, SCORE_TEXT, START_SCORE_TEXT)

    init {
        initUi()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackgroundDrawable(uiSkin.getSprite(BACKGROUND_DRAWABLE_PATH)))
        val topGroup = Table()
        topGroup.add(backgroundSpawnInfo).row()
        topGroup
            .add(lvlGameInfo)
            .expandX()
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(30f)
            .row()
        topGroup
            .add(linesInfo)
            .expandX()
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(20f)
            .row()
        topGroup
            .add(scoreInfo)
            .expandX()
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(20f)
            .row()
        root.add(topGroup).expandX().expandY().align(Align.topRight).row()
        root.pad(8f).padTop(26f)
        addActor(root)
    }

    private companion object {

    }
}
