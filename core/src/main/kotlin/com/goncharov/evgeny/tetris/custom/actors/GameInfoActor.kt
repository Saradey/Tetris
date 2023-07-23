package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.goncharov.evgeny.tetris.resources.LABEL_SCORE_RESULT_STYLE
import com.goncharov.evgeny.tetris.resources.LABEL_SCORE_STYLE

class GameInfoActor(
    uiSkin: Skin,
    titleText: String,
    resultText: String
) : Table() {

    private val titleLabel = Label(titleText, uiSkin, LABEL_SCORE_STYLE)
    private val resultLabel = Label(resultText, uiSkin, LABEL_SCORE_RESULT_STYLE)

    init {
        initUi()
    }

    private fun initUi() {
        add(titleLabel).expandX()
        add(resultLabel).expandX()
    }

    fun setResultText(result: String) {
        resultLabel.setText(result)
    }
}
