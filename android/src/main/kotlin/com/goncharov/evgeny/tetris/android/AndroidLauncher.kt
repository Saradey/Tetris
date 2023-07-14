package com.goncharov.evgeny.tetris.android

import android.os.Bundle

import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.goncharov.evgeny.tetris.Tetris

/** Launches the Android application. */
class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize(Tetris(), AndroidApplicationConfiguration().apply {
            // Configure your application here.
            useImmersiveMode = true // Recommended, but not required.
        })
    }
}
