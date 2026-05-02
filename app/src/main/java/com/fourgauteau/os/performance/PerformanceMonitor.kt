package com.fourgauteau.os.performance

import android.content.Context

object PerformanceMonitor {
    private var initialized = false
    private var startTime = 0L

    fun initialize(context: Context) {
        if (initialized) return
        initialized = true
        startTime = System.currentTimeMillis()
    }

    fun getPerformanceReport(): Map<String, Any> {
        return mapOf(
            "uptime_ms" to (System.currentTimeMillis() - startTime),
            "initialized" to initialized
        )
    }

    fun isPerformanceGood(): Boolean = true

    fun getPerformanceScore(): Int = 100
}
