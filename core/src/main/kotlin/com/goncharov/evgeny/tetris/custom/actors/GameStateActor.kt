package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.goncharov.evgeny.tetris.resources.PAUSE_TEXT
import com.goncharov.evgeny.tetris.resources.QUIT_TEXT

class GameStateActor(
    uiSkin: Skin
) : Table() {

    private val quitButton = ImageTextButton(QUIT_TEXT, uiSkin)
    private val pauseButton = ImageTextButton(PAUSE_TEXT, uiSkin)

    init {
        initUi()
    }

    private fun initUi() {

    }
}
