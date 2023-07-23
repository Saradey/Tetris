package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.goncharov.evgeny.tetris.resources.TITLE_DRAWABLE_PATH
import com.goncharov.evgeny.tetris.resources.TITLE_SHAPE_DRAWABLE_PATH

class TitleActor(
    uiSkin: Skin
) : Table() {

    private val title = Image(uiSkin, TITLE_DRAWABLE_PATH)
    private val titleDot = Image(uiSkin, TITLE_SHAPE_DRAWABLE_PATH)

    init {
        initUi()
    }

    private fun initUi() {
        add(titleDot).padLeft(84f).row()
        add(title)
    }

    fun initActions() {
        title.addAction(
            Actions.sequence(
                Actions.alpha(0f),
                Actions.fadeIn(0.3f)
            )
        )
        titleDot.addAction(
            Actions.parallel(
                Actions.alpha(0f),
                Actions.fadeIn(0.3f),
                Actions.moveBy(0f, -18f, 0.3f)
            )
        )
    }
}
