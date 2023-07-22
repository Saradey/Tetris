package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.goncharov.evgeny.tetris.resources.BUTTON_LEFT_STYLE
import com.goncharov.evgeny.tetris.resources.START_DIFFICULTY_LVL_TEXT

class DifficultyLevelActor(
    uiSkin: Skin
) : Table() {

    private val rightButton: Button = Button(uiSkin)
    private val leftButton: Button = Button(uiSkin, BUTTON_LEFT_STYLE)
    private val lvlDifficultyLabel = Label(START_DIFFICULTY_LVL_TEXT, uiSkin)

    init {
        initUi()
    }

    private fun initUi() {
        add(leftButton).padRight(20f)
        leftButton.isDisabled = true
        add(lvlDifficultyLabel)
        add(rightButton).padLeft(20f)
    }

    private companion object {

    }
}
