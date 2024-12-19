package org.hyperskill.example.core.injection

import org.hyperskill.example.core.model.BuildVariant
import org.hyperskill.example.core.model.Platform

internal class IosAppGraph(
    platform: Platform,
    buildVariant: BuildVariant
) : SharedIosAppGraph, BaseAppGraph(platform, buildVariant)