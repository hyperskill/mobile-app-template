package org.hyperskill.example.core.injection

import android.content.Context

interface SharedAndroidAppGraph : AppGraph {
    val context: Context
}