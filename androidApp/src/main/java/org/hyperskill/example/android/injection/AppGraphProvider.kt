package org.hyperskill.example.android.injection

import org.hyperskill.example.android.ExampleApp

fun provideAppGraph(): AndroidAppGraph =
    ExampleApp.graph()