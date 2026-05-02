package com.fourgauteau.os.data

object Constants {
    const val FLAG_LAUNCH_APP = 1
    const val FLAG_HIDDEN_APPS = 2
    const val FLAG_SET_HOME_APP_1 = 3
    const val FLAG_SET_HOME_APP_2 = 4
    const val FLAG_SET_HOME_APP_3 = 5
    const val FLAG_SET_HOME_APP_4 = 6
    const val FLAG_SET_HOME_APP_5 = 7
    const val FLAG_SET_HOME_APP_6 = 8
    const val FLAG_SET_HOME_APP_7 = 9
    const val FLAG_SET_HOME_APP_8 = 10
    const val FLAG_SET_SWIPE_LEFT_APP = 11
    const val FLAG_SET_SWIPE_RIGHT_APP = 12
    const val FLAG_SET_CLOCK_APP = 13
    const val FLAG_SET_CALENDAR_APP = 14
    const val FLAG_SET_SCREEN_TIME_APP = 15

    const val REQUEST_CODE_ENABLE_ADMIN = 666
    const val REQUEST_CODE_LAUNCHER_SELECTOR = 1000

    const val URL_OLAUNCHER_PRO = "https://play.google.com/store/apps/details?id=app.olauncher.paid"

    const val WALLPAPER_WORKER_NAME = "WallpaperWorker"

    val CLOCK_APP_PACKAGES = listOf(
        "com.google.android.deskclock",
        "com.android.deskclock",
        "com.sec.android.app.clockpackage",
        "com.htc.android.worldclock"
    )

    enum class Dialog {
        ABOUT, WALLPAPER, REVIEW, RATE, SHARE, HIDDEN, KEYBOARD, DIGITAL_WELLBEING, PRO_MESSAGE
    }

    enum class UserState {
        START, WALLPAPER, REVIEW, RATE, SHARE
    }
}
