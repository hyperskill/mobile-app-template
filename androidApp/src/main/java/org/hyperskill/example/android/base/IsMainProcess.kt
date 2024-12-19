package org.hyperskill.example.android.base

import android.app.ActivityManager
import android.content.Context

/**
 * Returns true if current process is app's main process
 */
val Context.isMainProcess: Boolean
    get() {
        val pid = android.os.Process.myPid()
        return (getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager)
            ?.runningAppProcesses
            ?.find { it.pid == pid }
            ?.processName
            ?.let { it.isNotEmpty() && it == packageName }
            ?: false
    }