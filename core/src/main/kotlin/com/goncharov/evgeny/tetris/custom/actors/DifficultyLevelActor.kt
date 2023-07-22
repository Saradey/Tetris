package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.goncharov.evgeny.tetris.resources.START_DIFFICULTY_LVL

class DifficultyLevelActor(
    uiSkin: Skin
) : Table() {

    private val rightButton: Button = Button(uiSkin)
    private val leftButton: Button = Button(uiSkin).apply {
        rotation = 90f
        isDisabled = false
    }
    private val lvlDifficultyLabel = Label(START_DIFFICULTY_LVL, uiSkin)

    init {
        initUi()
    }

    private fun initUi() {
        add(leftButton)
        add(lvlDifficultyLabel)
        add(rightButton)
    }
}
