package org.hyperskill.example.core.injection

import org.hyperskill.example.core.model.BuildVariant
import org.hyperskill.example.core.model.Platform

internal class CommonComponentImpl(
    override val platform: Platform,
    override val buildVariant: BuildVariant
) : CommonComponent