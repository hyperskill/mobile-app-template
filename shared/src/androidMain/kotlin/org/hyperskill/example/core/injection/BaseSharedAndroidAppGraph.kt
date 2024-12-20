package org.hyperskill.example.core.injection

import android.content.Context
import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform

abstract class BaseSharedAndroidAppGraph(
    override val context: Context,
    platform: Platform,
    buildVariant: BuildVariant,
) : SharedAndroidAppGraph,
    BaseAppGraph(platform, buildVariant)