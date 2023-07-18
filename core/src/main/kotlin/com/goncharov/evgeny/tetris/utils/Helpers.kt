package com.goncharov.evgeny.tetris.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

private val colorBackground = Color(0.8666667f, 0.93333334f, 1f, 1f)

fun clearScreen() {
    Gdx.gl.glClearColor(colorBackground.r, colorBackground.g, colorBackground.b, colorBackground.a)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
}

inline fun Actor.addListenerKtx(crossinline action: () -> Unit) {
    this.addListener(object : ClickListener() {
        override fun clicked(event: InputEvent?, x: Float, y: Float) {
            action()
        }
    })
}
