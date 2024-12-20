package org.hyperskill.example.base.injection

import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform

fun CommonComponent(
    platform: Platform,
    buildVariant: BuildVariant
) : CommonComponent =
    CommonComponentImpl(platform, buildVariant)

private class CommonComponentImpl(
    override val platform: Platform,
    override val buildVariant: BuildVariant
) : CommonComponent