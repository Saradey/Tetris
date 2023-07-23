package com.goncharov.evgeny.tetris.screens.game.ui

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.Viewport
import com.goncharov.evgeny.tetris.custom.actors.GameInfoActor
import com.goncharov.evgeny.tetris.custom.actors.GameStateActor
import com.goncharov.evgeny.tetris.custom.actors.MainBackgroundDrawable
import com.goncharov.evgeny.tetris.custom.actors.TitleActor
import com.goncharov.evgeny.tetris.navigation.Navigator
import com.goncharov.evgeny.tetris.resources.BACKGROUND_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.LEVEL_START_SCORE_TEXT
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
    private val lvlGameInfo = GameInfoActor(uiSkin, LEVEL_TEXT, LEVEL_START_SCORE_TEXT)
    private val linesInfo = GameInfoActor(uiSkin, LINES_TEXT, START_SCORE_TEXT)
    private val scoreInfo = GameInfoActor(uiSkin, SCORE_TEXT, START_SCORE_TEXT)
    private val gameStateActor = GameStateActor(uiSkin)
    private val titleActor = TitleActor(uiSkin)
    private val topGroup = Table()

    init {
        initUi()
        initActions()
    }

    private fun initUi() {
        root.setFillParent(true)
        root.background(MainBackgroundDrawable(uiSkin.getSprite(BACKGROUND_DRAWABLE_PATH)))
        topGroup
            .add(backgroundSpawnInfo)
            .row()
        backgroundSpawnInfo.addAction(Actions.alpha(0f))
        topGroup
            .add(lvlGameInfo)
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(30f)
            .row()
        lvlGameInfo.addAction(Actions.alpha(0f))
        topGroup
            .add(linesInfo)
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(20f)
            .row()
        linesInfo.addAction(Actions.alpha(0f))
        topGroup
            .add(scoreInfo)
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(20f)
            .row()
        scoreInfo.addAction(Actions.alpha(0f))
        root
            .add(topGroup)
            .expandX()
            .expandY()
            .align(Align.topRight)
            .row()
        root
            .add(gameStateActor)
            .align(Align.bottomRight)
            .width(backgroundSpawnInfo.width)
            .spaceBottom(30f)
            .row()
        gameStateActor.addAction(Actions.alpha(0f))
        root
            .add(titleActor)
            .align(Align.bottomRight)
            .width(backgroundSpawnInfo.width)
        root.pad(8f)
        addActor(root)
    }

    private fun initActions() {
        titleActor.initActions {
            initSecondActions()
        }
    }

    private fun initSecondActions() {
        initFadeInAction(lvlGameInfo)
        initFadeInAction(linesInfo)
        initFadeInAction(scoreInfo)
        initFadeInAction(gameStateActor)
    }

    private fun initFadeInAction(actor: Actor, endCall: () -> Unit? = null) {
        actor.addAction(
            Actions.sequence(
                Actions.fadeIn(0.3f),
                Actions.run {

                }
            )
        )
    }

    private companion object {

    }
}
