package com.fourgauteau.os.helper

import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.UserHandle
import android.os.UserManager
import android.provider.Settings
import android.util.TypedValue
import android.widget.Toast
import com.fourgauteau.os.data.AppModel
import com.fourgauteau.os.data.Prefs
import java.util.Calendar

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.isDarkThemeOn(): Boolean {
    return resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
}

fun Context.isDefaultLauncher(): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_MAIN).apply { addCategory(Intent.CATEGORY_HOME) }
        val resolveInfo = packageManager.resolveActivity(intent, 0)
        resolveInfo?.activityInfo?.packageName == packageName
    } catch (e: Exception) {
        false
    }
}

fun Context.isOlauncherDefault(context: Context): Boolean = context.isDefaultLauncher()

fun isOlauncherDefault(context: Context): Boolean = context.isDefaultLauncher()

fun Context.isPackageInstalled(packageName: String): Boolean {
    return try {
        packageManager.getPackageInfo(packageName, 0)
        true
    } catch (e: Exception) {
        false
    }
}

fun isTablet(context: Context): Boolean {
    val xlarge = context.resources.configuration.screenLayout and
            Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_XLARGE
    val large = context.resources.configuration.screenLayout and
            Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE
    return xlarge || large
}

fun isEinkDisplay(): Boolean = false

fun Context.openUrl(url: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.rateApp() {
    openUrl("market://details?id=$packageName")
}

fun Context.shareApp() {
    try {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=$packageName")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(Intent.createChooser(intent, null).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.setPlainWallpaper() {
    setPlainWallpaper(this, android.R.color.black)
}

fun setPlainWallpaper(context: Context, colorRes: Int) {
    try {
        val color = context.resources.getColor(colorRes, context.theme)
        val wallpaperManager = WallpaperManager.getInstance(context)
        wallpaperManager.setResource(colorRes)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.showLauncherSelector(requestCode: Int) {
    try {
        val intent = Intent(Settings.ACTION_HOME_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Context.resetLauncherViaFakeActivity() {
    try {
        val componentName = ComponentName(this, "com.fourgauteau.os.helper.FakeHomeActivity")
        packageManager.setComponentEnabledSetting(
            componentName,
            android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            android.content.pm.PackageManager.DONT_KILL_APP
        )
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        packageManager.setComponentEnabledSetting(
            componentName,
            android.content.pm.PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            android.content.pm.PackageManager.DONT_KILL_APP
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Long.hasBeenDays(days: Int): Boolean {
    val diff = System.currentTimeMillis() - this
    return diff >= days * 24 * 60 * 60 * 1000L
}

fun Long.hasBeenHours(hours: Int): Boolean {
    val diff = System.currentTimeMillis() - this
    return diff >= hours * 60 * 60 * 1000L
}

fun Long.hasBeenMinutes(minutes: Int): Boolean {
    val diff = System.currentTimeMillis() - this
    return diff >= minutes * 60 * 1000L
}

fun Long.isDaySince(): Int {
    val diff = System.currentTimeMillis() - this
    return (diff / (24 * 60 * 60 * 1000L)).toInt()
}

fun Context.getColorFromAttr(attrId: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrId, typedValue, true)
    return typedValue.data
}

fun Context.formattedTimeSpent(usageStats: Any?): String {
    if (usageStats == null) return "0m"
    val totalMs = when (usageStats) {
        is Long -> usageStats
        is Map<*, *> -> (usageStats.values.filterIsInstance<Long>().sum())
        else -> 0L
    }
    val hours = totalMs / (60 * 60 * 1000L)
    val minutes = (totalMs % (60 * 60 * 1000L)) / (60 * 1000L)
    return when {
        hours > 0 -> "${hours}h ${minutes}m"
        else -> "${minutes}m"
    }
}

fun getAppsList(
    context: Context,
    prefs: Prefs,
    includeRegularApps: Boolean,
    includeHiddenApps: Boolean
): List<AppModel> {
    return try {
        val launcherApps = context.getSystemService(Context.LAUNCHER_APPS_SERVICE)
                as android.content.pm.LauncherApps
        val userManager = context.getSystemService(Context.USER_SERVICE) as UserManager
        val profiles = userManager.userProfiles

        val apps = mutableListOf<AppModel>()
        for (profile in profiles) {
            val activityList = launcherApps.getActivityList(null, profile)
            for (info in activityList) {
                val packageName = info.applicationInfo.packageName
                apps.add(
                    AppModel.App(
                        appLabel = info.label.toString(),
                        appPackage = packageName,
                        activityClassName = info.componentName.className,
                        user = profile
                    )
                )
            }
        }
        apps.sortBy { (it as AppModel.App).appLabel.lowercase() }
        apps
    } catch (e: Exception) {
        emptyList()
    }
}

fun getPrivateSpaceApps(context: Context, prefs: Prefs): List<AppModel> {
    val handle = getPrivateSpaceUserHandle(context) ?: return emptyList()
    return getPrivateSpaceApps(context, handle)
}

fun getPrivateSpaceApps(context: Context, userHandle: UserHandle): List<AppModel> {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) return emptyList()
    return try {
        val launcherApps = context.getSystemService(Context.LAUNCHER_APPS_SERVICE)
                as android.content.pm.LauncherApps
        val activityList = launcherApps.getActivityList(null, userHandle)
        val apps = activityList.map { info ->
            AppModel.App(
                appLabel = info.label.toString(),
                appPackage = info.applicationInfo.packageName,
                activityClassName = info.componentName.className,
                user = userHandle
            )
        }
        listOf(AppModel.PrivateSpaceHeader) + apps.sortedBy { it.appLabel.lowercase() }
    } catch (e: Exception) {
        emptyList()
    }
}

fun getPrivateSpaceUserHandle(context: Context): UserHandle? {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) return null
    return try {
        val userManager = context.getSystemService(Context.USER_SERVICE) as UserManager
        val myHandle = android.os.Process.myUserHandle()
        userManager.userProfiles.firstOrNull { handle -> handle != myHandle }
    } catch (e: Exception) {
        null
    }
}

fun isPrivateSpaceLocked(context: Context): Boolean {
    val handle = getPrivateSpaceUserHandle(context) ?: return false
    return isPrivateSpaceLocked(context, handle)
}

fun isPrivateSpaceLocked(context: Context, userHandle: UserHandle): Boolean {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) return false
    return try {
        val userManager = context.getSystemService(Context.USER_SERVICE) as UserManager
        userManager.isQuietModeEnabled(userHandle)
    } catch (e: Exception) {
        false
    }
}
