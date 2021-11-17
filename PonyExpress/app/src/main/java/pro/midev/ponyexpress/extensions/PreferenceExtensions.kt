package pro.midev.ponyexpress.extensions

import android.content.Context
import pro.midev.supersld.common.PreferenceHelper

const val PONY_PREFS = "prefs"

const val THEME = "is_day"
const val AUTH = "is_auth"
fun Context.saveThemeIsDay(isDay: Boolean) {
    PreferenceHelper.customPrefs(this, PONY_PREFS).edit().putBoolean(THEME, isDay).apply()
}

fun Context.themeIsDay(): Boolean {
    return PreferenceHelper.customPrefs(this, PONY_PREFS).getBoolean(THEME, true)
}

fun Context.saveAuthState(isDay: Boolean) {
    PreferenceHelper.customPrefs(this, PONY_PREFS).edit().putBoolean(AUTH, isDay).apply()
}

fun Context.isAuth(): Boolean {
    return PreferenceHelper.customPrefs(this, PONY_PREFS).getBoolean(AUTH, false)
}