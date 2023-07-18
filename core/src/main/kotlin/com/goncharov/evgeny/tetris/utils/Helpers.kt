package com.goncharov.evgeny.tetris.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20

fun clearScreen() {
    Gdx.gl.glClearColor(221f, 238f, 255f, 1f)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
}
