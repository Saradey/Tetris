package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.goncharov.evgeny.tetris.resources.BUTTON_LEFT_STYLE
import com.goncharov.evgeny.tetris.resources.START_DIFFICULTY_LVL_TEXT
import com.goncharov.evgeny.tetris.utils.addListenerKtx

class DifficultyLevelActor(
    uiSkin: Skin
) : Table() {

    private val rightButton: Button = Button(uiSkin)
    private val leftButton: Button = Button(uiSkin, BUTTON_LEFT_STYLE)
    private val lvlDifficultyLabel = Label(START_DIFFICULTY_LVL_TEXT, uiSkin)
    private var difficultyLevel: Int = 1

    init {
        initUi()
    }

    private fun initUi() {
        add(leftButton).padRight(20f)
        leftButton.isDisabled = true
        add(lvlDifficultyLabel)
        add(rightButton).padLeft(20f)
    }

    fun initListenerDifficultyLevel(action: (Int) -> Unit) {
        leftButton.addListenerKtx {
            if (difficultyLevel > 1) {
                difficultyLevel--
                if (difficultyLevel < 10) {
                    rightButton.isDisabled = false
                }
                lvlDifficultyLabel.setText(difficultyLevel)
                if (difficultyLevel == 1) {
                    leftButton.isDisabled = true
                }
                action(difficultyLevel)
            }
        }
        rightButton.addListenerKtx {
            if (difficultyLevel < 10) {
                difficultyLevel++
                if (difficultyLevel == 10) {
                    rightButton.isDisabled = true
                }
                lvlDifficultyLabel.setText(difficultyLevel)
                if (difficultyLevel > 1) {
                    leftButton.isDisabled = false
                }
                action(difficultyLevel)
            }
        }
    }

    private companion object {

    }
}
