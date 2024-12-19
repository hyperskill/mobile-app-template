package org.hyperskill.example.core.injection

import org.hyperskill.example.core.model.BuildVariant
import org.hyperskill.example.core.model.Platform

interface CommonComponent {
    val platform: Platform
    val buildVariant: BuildVariant
}