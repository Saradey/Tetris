package com.goncharov.evgeny.tetris.utils

import com.badlogic.gdx.Gdx
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

class KoinLogger : Logger() {

    override fun display(level: Level, msg: MESSAGE) {
        if (level == Level.DEBUG) {
            Gdx.app.debug(KOIN_TAG, msg)
        }
    }

    private companion object {
        const val KOIN_TAG = "KOIN_TAG"
    }
}
