package org.hyperskill.example.android.injection

import android.content.Context
import org.hyperskill.example.core.injection.BaseSharedAndroidAppGraph
import org.hyperskill.example.core.model.BuildVariant
import org.hyperskill.example.core.model.Platform

class AndroidAppGraph(
    context: Context,
    platform: Platform,
    buildVariant: BuildVariant
) : BaseSharedAndroidAppGraph(
    context = context,
    platform = platform,
    buildVariant = buildVariant
)