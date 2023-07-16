@file:JvmName("Lwjgl3Launcher")

package com.goncharov.evgeny.tetris.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.goncharov.evgeny.tetris.CoreApp
import com.goncharov.evgeny.tetris.utils.WINDOW_DESKTOP_HEIGHT_SIZE
import com.goncharov.evgeny.tetris.utils.WINDOW_DESKTOP_WIDTH_SIZE

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(CoreApp(), Lwjgl3ApplicationConfiguration().apply {
        setResizable(false)
        setTitle("Tetris")
        setWindowedMode(WINDOW_DESKTOP_WIDTH_SIZE, WINDOW_DESKTOP_HEIGHT_SIZE)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
