package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable

class MainBackgroundDrawable(
    private val sprite: Sprite
) : SpriteDrawable(sprite) {

    override fun draw(batch: Batch, x: Float, y: Float, width: Float, height: Float) {
        for (position in POSITION_START..POSITION_END step STEP) {
            sprite.x = position.toFloat()
            sprite.draw(batch)
        }
    }

    private companion object {
        const val POSITION_START = -600
        const val POSITION_END = 600
        const val STEP = 10
    }
}
