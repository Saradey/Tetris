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
        add(leftButton).padRight(INTERNAL_PADDING)
        leftButton.isDisabled = true
        add(lvlDifficultyLabel)
        add(rightButton).padLeft(INTERNAL_PADDING)
    }

    fun initListenerDifficultyLevel(action: (Int) -> Unit) {
        leftButton.addListenerKtx {
            if (difficultyLevel > LEVEL_MINIMUM) {
                difficultyLevel--
                if (difficultyLevel < LEVEL_MAXIMUM) {
                    rightButton.isDisabled = false
                }
                lvlDifficultyLabel.setText(difficultyLevel)
                if (difficultyLevel == LEVEL_MINIMUM) {
                    leftButton.isDisabled = true
                }
                action(difficultyLevel)
            }
        }
        rightButton.addListenerKtx {
            if (difficultyLevel < LEVEL_MAXIMUM) {
                difficultyLevel++
                if (difficultyLevel == LEVEL_MAXIMUM) {
                    rightButton.isDisabled = true
                }
                lvlDifficultyLabel.setText(difficultyLevel)
                if (difficultyLevel > LEVEL_MINIMUM) {
                    leftButton.isDisabled = false
                }
                action(difficultyLevel)
            }
        }
    }

    private companion object {
        const val INTERNAL_PADDING = 20f
        const val LEVEL_MINIMUM = 1
        const val LEVEL_MAXIMUM = 10
    }
}
