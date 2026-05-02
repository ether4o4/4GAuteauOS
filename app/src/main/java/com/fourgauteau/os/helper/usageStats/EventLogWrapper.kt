package com.fourgauteau.os.helper.usageStats

import android.content.Context
import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.os.Build

class EventLogWrapper(private val context: Context) {

    fun getForegroundStatsByTimestamps(startTime: Long, endTime: Long): List<UsageEvents.Event> {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return emptyList()
        return try {
            val usageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
            val events = usageStatsManager.queryEvents(startTime, endTime)
            val eventList = mutableListOf<UsageEvents.Event>()
            while (events.hasNextEvent()) {
                val event = UsageEvents.Event()
                events.getNextEvent(event)
                if (event.eventType == UsageEvents.Event.ACTIVITY_RESUMED ||
                    event.eventType == UsageEvents.Event.ACTIVITY_PAUSED) {
                    eventList.add(event)
                }
            }
            eventList
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun aggregateForegroundStats(events: List<UsageEvents.Event>): Map<String, Long> {
        val result = mutableMapOf<String, Long>()
        var lastResumed: Pair<String, Long>? = null
        for (event in events.sortedBy { it.timeStamp }) {
            when (event.eventType) {
                UsageEvents.Event.ACTIVITY_RESUMED -> lastResumed = Pair(event.packageName, event.timeStamp)
                UsageEvents.Event.ACTIVITY_PAUSED -> {
                    if (lastResumed?.first == event.packageName) {
                        val duration = event.timeStamp - (lastResumed?.second ?: event.timeStamp)
                        result[event.packageName] = (result[event.packageName] ?: 0L) + duration
                        lastResumed = null
                    }
                }
            }
        }
        return result
    }

    fun aggregateSimpleUsageStats(stats: Map<String, Long>): Long {
        return stats.values.sum()
    }
}
