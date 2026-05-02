package com.fourgauteau.os.data

import android.os.UserHandle

sealed class AppModel {
    data class App(
        val appLabel: String,
        val appPackage: String,
        val activityClassName: String?,
        val user: UserHandle,
        val isNew: Boolean = false
    ) : AppModel()

    data class PinnedShortcut(
        val appLabel: String,
        val appPackage: String,
        val shortcutId: String,
        val user: UserHandle
    ) : AppModel()

    object PrivateSpaceHeader : AppModel()
}
