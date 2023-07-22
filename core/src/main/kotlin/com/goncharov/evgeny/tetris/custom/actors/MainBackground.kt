package com.goncharov.evgeny.tetris.custom.actors

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable

class MainBackground(
    private val sprite: Sprite
) : SpriteDrawable(sprite) {

    override fun draw(batch: Batch, x: Float, y: Float, width: Float, height: Float) {
        for (position in -600..600 step 10) {
            sprite.x = position.toFloat()
            sprite.draw(batch)
        }
    }
}
