package org.hyperskill.example.android.base.model

import org.hyperskill.example.android.BuildConfig
import org.hyperskill.example.base.model.BuildVariant

val AndroidBuildVariant: BuildVariant =
    BuildVariant.getByValue(BuildConfig.BUILD_TYPE)!!