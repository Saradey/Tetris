package com.goncharov.evgeny.tetris.service.locator.scopes

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue

object ViewPortScope : Qualifier {

    private const val QUALIFIER_NAME = "ViewPortScope"

    override val value: QualifierValue = QUALIFIER_NAME
}
