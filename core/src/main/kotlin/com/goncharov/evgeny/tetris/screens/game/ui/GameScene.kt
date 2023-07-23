package com.goncharov.evgeny.tetris.screens.game.ui

import com.badlogic.gdx.graphics.g2d.SpriteBatch
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
        backgroundSpawnInfo.addAction(Actions.alpha(START_ALPHA_VALUE))
        topGroup
            .add(lvlGameInfo)
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(MAIN_MARGIN)
            .row()
        lvlGameInfo.addAction(Actions.alpha(START_ALPHA_VALUE))
        topGroup
            .add(linesInfo)
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(SECOND_MARGIN)
            .row()
        linesInfo.addAction(Actions.alpha(START_ALPHA_VALUE))
        topGroup
            .add(scoreInfo)
            .align(Align.topRight)
            .width(backgroundSpawnInfo.width)
            .spaceTop(SECOND_MARGIN)
            .row()
        scoreInfo.addAction(Actions.alpha(START_ALPHA_VALUE))
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
            .spaceBottom(MAIN_MARGIN)
            .row()
        gameStateActor.addAction(Actions.alpha(START_ALPHA_VALUE))
        root
            .add(titleActor)
            .align(Align.bottomRight)
            .width(backgroundSpawnInfo.width)
        root.pad(PADDING_ROOT)
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
        initFadeInAction(gameStateActor) {
            initFadeInAction(backgroundSpawnInfo)
        }
    }

    private fun initFadeInAction(actor: Actor, endCall: (() -> Unit)? = null) {
        actor.addAction(
            Actions.sequence(
                Actions.fadeIn(ALL_ANIMATION_DURATION),
                Actions.run {
                    endCall?.invoke()
                }
            )
        )
    }

    private companion object {

        const val START_ALPHA_VALUE = 0f
        const val ALL_ANIMATION_DURATION = 0.3f
        const val MAIN_MARGIN = 30f
        const val PADDING_ROOT = 8f
        const val SECOND_MARGIN = 20f
    }
}
