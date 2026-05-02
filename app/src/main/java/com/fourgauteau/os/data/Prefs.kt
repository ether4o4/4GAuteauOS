package com.fourgauteau.os.data

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatDelegate

class Prefs(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("fourgauteau_prefs", Context.MODE_PRIVATE)

    var firstOpen: Boolean
        get() = prefs.getBoolean("firstOpen", true)
        set(value) = prefs.edit().putBoolean("firstOpen", value).apply()

    var firstOpenTime: Long
        get() = prefs.getLong("firstOpenTime", 0L)
        set(value) = prefs.edit().putLong("firstOpenTime", value).apply()

    var appTheme: Int
        get() = prefs.getInt("appTheme", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        set(value) = prefs.edit().putInt("appTheme", value).apply()

    var lockModeOn: Boolean
        get() = prefs.getBoolean("lockModeOn", false)
        set(value) = prefs.edit().putBoolean("lockModeOn", value).apply()

    var wallpaperMsgShown: Boolean
        get() = prefs.getBoolean("wallpaperMsgShown", false)
        set(value) = prefs.edit().putBoolean("wallpaperMsgShown", value).apply()

    var dailyWallpaper: Boolean
        get() = prefs.getBoolean("dailyWallpaper", false)
        set(value) = prefs.edit().putBoolean("dailyWallpaper", value).apply()

    var userState: Constants.UserState
        get() = Constants.UserState.valueOf(
            prefs.getString("userState", Constants.UserState.START.name) ?: Constants.UserState.START.name
        )
        set(value) = prefs.edit().putString("userState", value.name).apply()

    var rateClicked: Boolean
        get() = prefs.getBoolean("rateClicked", false)
        set(value) = prefs.edit().putBoolean("rateClicked", value).apply()

    var shareShownTime: Long
        get() = prefs.getLong("shareShownTime", 0L)
        set(value) = prefs.edit().putLong("shareShownTime", value).apply()

    var shownOnDayOfYear: Int
        get() = prefs.getInt("shownOnDayOfYear", 0)
        set(value) = prefs.edit().putInt("shownOnDayOfYear", value).apply()

    var textSizeScale: Float
        get() = prefs.getFloat("textSizeScale", 1.0f)
        set(value) = prefs.edit().putFloat("textSizeScale", value).apply()

    var orientation: Int
        get() = prefs.getInt("orientation", ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        set(value) = prefs.edit().putInt("orientation", value).apply()

    var homeButtonShowRecents: Boolean
        get() = prefs.getBoolean("homeButtonShowRecents", false)
        set(value) = prefs.edit().putBoolean("homeButtonShowRecents", value).apply()

    var launcherRestartTimestamp: Long
        get() = prefs.getLong("launcherRestartTimestamp", 0L)
        set(value) = prefs.edit().putLong("launcherRestartTimestamp", value).apply()

    // App slot 1
    var appName1: String
        get() = prefs.getString("appName1", "") ?: ""
        set(value) = prefs.edit().putString("appName1", value).apply()
    var appPackage1: String
        get() = prefs.getString("appPackage1", "") ?: ""
        set(value) = prefs.edit().putString("appPackage1", value).apply()
    var appUser1: String
        get() = prefs.getString("appUser1", "") ?: ""
        set(value) = prefs.edit().putString("appUser1", value).apply()
    var appActivityClassName1: String?
        get() = prefs.getString("appActivityClassName1", null)
        set(value) = prefs.edit().putString("appActivityClassName1", value).apply()
    var isShortcut1: Boolean
        get() = prefs.getBoolean("isShortcut1", false)
        set(value) = prefs.edit().putBoolean("isShortcut1", value).apply()
    var shortcutId1: String
        get() = prefs.getString("shortcutId1", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId1", value).apply()

    // App slot 2
    var appName2: String
        get() = prefs.getString("appName2", "") ?: ""
        set(value) = prefs.edit().putString("appName2", value).apply()
    var appPackage2: String
        get() = prefs.getString("appPackage2", "") ?: ""
        set(value) = prefs.edit().putString("appPackage2", value).apply()
    var appUser2: String
        get() = prefs.getString("appUser2", "") ?: ""
        set(value) = prefs.edit().putString("appUser2", value).apply()
    var appActivityClassName2: String?
        get() = prefs.getString("appActivityClassName2", null)
        set(value) = prefs.edit().putString("appActivityClassName2", value).apply()
    var isShortcut2: Boolean
        get() = prefs.getBoolean("isShortcut2", false)
        set(value) = prefs.edit().putBoolean("isShortcut2", value).apply()
    var shortcutId2: String
        get() = prefs.getString("shortcutId2", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId2", value).apply()

    // App slot 3
    var appName3: String
        get() = prefs.getString("appName3", "") ?: ""
        set(value) = prefs.edit().putString("appName3", value).apply()
    var appPackage3: String
        get() = prefs.getString("appPackage3", "") ?: ""
        set(value) = prefs.edit().putString("appPackage3", value).apply()
    var appUser3: String
        get() = prefs.getString("appUser3", "") ?: ""
        set(value) = prefs.edit().putString("appUser3", value).apply()
    var appActivityClassName3: String?
        get() = prefs.getString("appActivityClassName3", null)
        set(value) = prefs.edit().putString("appActivityClassName3", value).apply()
    var isShortcut3: Boolean
        get() = prefs.getBoolean("isShortcut3", false)
        set(value) = prefs.edit().putBoolean("isShortcut3", value).apply()
    var shortcutId3: String
        get() = prefs.getString("shortcutId3", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId3", value).apply()

    // App slot 4
    var appName4: String
        get() = prefs.getString("appName4", "") ?: ""
        set(value) = prefs.edit().putString("appName4", value).apply()
    var appPackage4: String
        get() = prefs.getString("appPackage4", "") ?: ""
        set(value) = prefs.edit().putString("appPackage4", value).apply()
    var appUser4: String
        get() = prefs.getString("appUser4", "") ?: ""
        set(value) = prefs.edit().putString("appUser4", value).apply()
    var appActivityClassName4: String?
        get() = prefs.getString("appActivityClassName4", null)
        set(value) = prefs.edit().putString("appActivityClassName4", value).apply()
    var isShortcut4: Boolean
        get() = prefs.getBoolean("isShortcut4", false)
        set(value) = prefs.edit().putBoolean("isShortcut4", value).apply()
    var shortcutId4: String
        get() = prefs.getString("shortcutId4", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId4", value).apply()

    // App slot 5
    var appName5: String
        get() = prefs.getString("appName5", "") ?: ""
        set(value) = prefs.edit().putString("appName5", value).apply()
    var appPackage5: String
        get() = prefs.getString("appPackage5", "") ?: ""
        set(value) = prefs.edit().putString("appPackage5", value).apply()
    var appUser5: String
        get() = prefs.getString("appUser5", "") ?: ""
        set(value) = prefs.edit().putString("appUser5", value).apply()
    var appActivityClassName5: String?
        get() = prefs.getString("appActivityClassName5", null)
        set(value) = prefs.edit().putString("appActivityClassName5", value).apply()
    var isShortcut5: Boolean
        get() = prefs.getBoolean("isShortcut5", false)
        set(value) = prefs.edit().putBoolean("isShortcut5", value).apply()
    var shortcutId5: String
        get() = prefs.getString("shortcutId5", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId5", value).apply()

    // App slot 6
    var appName6: String
        get() = prefs.getString("appName6", "") ?: ""
        set(value) = prefs.edit().putString("appName6", value).apply()
    var appPackage6: String
        get() = prefs.getString("appPackage6", "") ?: ""
        set(value) = prefs.edit().putString("appPackage6", value).apply()
    var appUser6: String
        get() = prefs.getString("appUser6", "") ?: ""
        set(value) = prefs.edit().putString("appUser6", value).apply()
    var appActivityClassName6: String?
        get() = prefs.getString("appActivityClassName6", null)
        set(value) = prefs.edit().putString("appActivityClassName6", value).apply()
    var isShortcut6: Boolean
        get() = prefs.getBoolean("isShortcut6", false)
        set(value) = prefs.edit().putBoolean("isShortcut6", value).apply()
    var shortcutId6: String
        get() = prefs.getString("shortcutId6", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId6", value).apply()

    // App slot 7
    var appName7: String
        get() = prefs.getString("appName7", "") ?: ""
        set(value) = prefs.edit().putString("appName7", value).apply()
    var appPackage7: String
        get() = prefs.getString("appPackage7", "") ?: ""
        set(value) = prefs.edit().putString("appPackage7", value).apply()
    var appUser7: String
        get() = prefs.getString("appUser7", "") ?: ""
        set(value) = prefs.edit().putString("appUser7", value).apply()
    var appActivityClassName7: String?
        get() = prefs.getString("appActivityClassName7", null)
        set(value) = prefs.edit().putString("appActivityClassName7", value).apply()
    var isShortcut7: Boolean
        get() = prefs.getBoolean("isShortcut7", false)
        set(value) = prefs.edit().putBoolean("isShortcut7", value).apply()
    var shortcutId7: String
        get() = prefs.getString("shortcutId7", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId7", value).apply()

    // App slot 8
    var appName8: String
        get() = prefs.getString("appName8", "") ?: ""
        set(value) = prefs.edit().putString("appName8", value).apply()
    var appPackage8: String
        get() = prefs.getString("appPackage8", "") ?: ""
        set(value) = prefs.edit().putString("appPackage8", value).apply()
    var appUser8: String
        get() = prefs.getString("appUser8", "") ?: ""
        set(value) = prefs.edit().putString("appUser8", value).apply()
    var appActivityClassName8: String?
        get() = prefs.getString("appActivityClassName8", null)
        set(value) = prefs.edit().putString("appActivityClassName8", value).apply()
    var isShortcut8: Boolean
        get() = prefs.getBoolean("isShortcut8", false)
        set(value) = prefs.edit().putBoolean("isShortcut8", value).apply()
    var shortcutId8: String
        get() = prefs.getString("shortcutId8", "") ?: ""
        set(value) = prefs.edit().putString("shortcutId8", value).apply()

    // Swipe left app
    var appNameSwipeLeft: String
        get() = prefs.getString("appNameSwipeLeft", "") ?: ""
        set(value) = prefs.edit().putString("appNameSwipeLeft", value).apply()
    var appPackageSwipeLeft: String
        get() = prefs.getString("appPackageSwipeLeft", "") ?: ""
        set(value) = prefs.edit().putString("appPackageSwipeLeft", value).apply()
    var appUserSwipeLeft: String
        get() = prefs.getString("appUserSwipeLeft", "") ?: ""
        set(value) = prefs.edit().putString("appUserSwipeLeft", value).apply()
    var appActivityClassNameSwipeLeft: String?
        get() = prefs.getString("appActivityClassNameSwipeLeft", null)
        set(value) = prefs.edit().putString("appActivityClassNameSwipeLeft", value).apply()
    var isShortcutSwipeLeft: Boolean
        get() = prefs.getBoolean("isShortcutSwipeLeft", false)
        set(value) = prefs.edit().putBoolean("isShortcutSwipeLeft", value).apply()
    var shortcutIdSwipeLeft: String
        get() = prefs.getString("shortcutIdSwipeLeft", "") ?: ""
        set(value) = prefs.edit().putString("shortcutIdSwipeLeft", value).apply()

    // Swipe right app
    var appNameSwipeRight: String
        get() = prefs.getString("appNameSwipeRight", "") ?: ""
        set(value) = prefs.edit().putString("appNameSwipeRight", value).apply()
    var appPackageSwipeRight: String
        get() = prefs.getString("appPackageSwipeRight", "") ?: ""
        set(value) = prefs.edit().putString("appPackageSwipeRight", value).apply()
    var appUserSwipeRight: String
        get() = prefs.getString("appUserSwipeRight", "") ?: ""
        set(value) = prefs.edit().putString("appUserSwipeRight", value).apply()
    var appActivityClassNameRight: String?
        get() = prefs.getString("appActivityClassNameRight", null)
        set(value) = prefs.edit().putString("appActivityClassNameRight", value).apply()
    var isShortcutSwipeRight: Boolean
        get() = prefs.getBoolean("isShortcutSwipeRight", false)
        set(value) = prefs.edit().putBoolean("isShortcutSwipeRight", value).apply()
    var shortcutIdSwipeRight: String
        get() = prefs.getString("shortcutIdSwipeRight", "") ?: ""
        set(value) = prefs.edit().putString("shortcutIdSwipeRight", value).apply()

    // Clock app
    var clockAppPackage: String
        get() = prefs.getString("clockAppPackage", "") ?: ""
        set(value) = prefs.edit().putString("clockAppPackage", value).apply()
    var clockAppUser: String
        get() = prefs.getString("clockAppUser", "") ?: ""
        set(value) = prefs.edit().putString("clockAppUser", value).apply()
    var clockAppClassName: String?
        get() = prefs.getString("clockAppClassName", null)
        set(value) = prefs.edit().putString("clockAppClassName", value).apply()

    // Calendar app
    var calendarAppPackage: String
        get() = prefs.getString("calendarAppPackage", "") ?: ""
        set(value) = prefs.edit().putString("calendarAppPackage", value).apply()
    var calendarAppUser: String
        get() = prefs.getString("calendarAppUser", "") ?: ""
        set(value) = prefs.edit().putString("calendarAppUser", value).apply()
    var calendarAppClassName: String?
        get() = prefs.getString("calendarAppClassName", null)
        set(value) = prefs.edit().putString("calendarAppClassName", value).apply()

    // Screen time app
    var screenTimeAppPackage: String
        get() = prefs.getString("screenTimeAppPackage", "") ?: ""
        set(value) = prefs.edit().putString("screenTimeAppPackage", value).apply()
    var screenTimeAppUser: String
        get() = prefs.getString("screenTimeAppUser", "") ?: ""
        set(value) = prefs.edit().putString("screenTimeAppUser", value).apply()
    var screenTimeAppClassName: String?
        get() = prefs.getString("screenTimeAppClassName", null)
        set(value) = prefs.edit().putString("screenTimeAppClassName", value).apply()

    var dailyWallpaperUrl: String
        get() = prefs.getString("dailyWallpaperUrl", "") ?: ""
        set(value) = prefs.edit().putString("dailyWallpaperUrl", value).apply()

    var homeAlignment: Int
        get() = prefs.getInt("homeAlignment", android.view.Gravity.CENTER)
        set(value) = prefs.edit().putInt("homeAlignment", value).apply()

    var screenTimeLastUpdated: Long
        get() = prefs.getLong("screenTimeLastUpdated", 0L)
        set(value) = prefs.edit().putLong("screenTimeLastUpdated", value).apply()

    fun updateAppActivityClassName(packageName: String, className: String) {
        val slots = listOf(
            Triple({ appPackage1 }, { appActivityClassName1 }, { v: String? -> appActivityClassName1 = v }),
            Triple({ appPackage2 }, { appActivityClassName2 }, { v: String? -> appActivityClassName2 = v }),
            Triple({ appPackage3 }, { appActivityClassName3 }, { v: String? -> appActivityClassName3 = v }),
            Triple({ appPackage4 }, { appActivityClassName4 }, { v: String? -> appActivityClassName4 = v }),
            Triple({ appPackage5 }, { appActivityClassName5 }, { v: String? -> appActivityClassName5 = v }),
            Triple({ appPackage6 }, { appActivityClassName6 }, { v: String? -> appActivityClassName6 = v }),
            Triple({ appPackage7 }, { appActivityClassName7 }, { v: String? -> appActivityClassName7 = v }),
            Triple({ appPackage8 }, { appActivityClassName8 }, { v: String? -> appActivityClassName8 = v }),
        )
        slots.forEach { (getPackage, _, setClass) ->
            if (getPackage() == packageName) setClass(className)
        }
        if (appPackageSwipeLeft == packageName) appActivityClassNameSwipeLeft = className
        if (appPackageSwipeRight == packageName) appActivityClassNameRight = className
        if (clockAppPackage == packageName) clockAppClassName = className
        if (calendarAppPackage == packageName) calendarAppClassName = className
        if (screenTimeAppPackage == packageName) screenTimeAppClassName = className
    }
}
