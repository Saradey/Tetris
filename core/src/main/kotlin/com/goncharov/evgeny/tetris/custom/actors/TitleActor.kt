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
        add(titleDot).padLeft(MARGIN_LEFT_TITLE_DOT).row()
        add(title)
    }

    fun initActions(endCallback: (() -> Unit)? = null) {
        title.addAction(
            Actions.sequence(
                Actions.alpha(START_ALPHA_VALUE),
                Actions.fadeIn(ALL_DURATION_ANIMATION)
            )
        )
        titleDot.addAction(
            Actions.sequence(
                Actions.parallel(
                    Actions.alpha(START_ALPHA_VALUE),
                    Actions.fadeIn(ALL_DURATION_ANIMATION),
                    Actions.moveBy(0f, MOVE_Y_POSITION_ANIMATION, ALL_DURATION_ANIMATION)
                ),
                Actions.run {
                    endCallback?.invoke()
                }
            )
        )
    }

    private companion object {

        const val ALL_DURATION_ANIMATION = 0.3f
        const val START_ALPHA_VALUE = 0f
        const val MOVE_Y_POSITION_ANIMATION = -18f
        const val MARGIN_LEFT_TITLE_DOT = 84f
    }
}
