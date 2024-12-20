package org.hyperskill.example.base.injection

import org.hyperskill.example.base.model.BuildVariant
import org.hyperskill.example.base.model.Platform

interface CommonComponent {
    val platform: Platform
    val buildVariant: BuildVariant
}