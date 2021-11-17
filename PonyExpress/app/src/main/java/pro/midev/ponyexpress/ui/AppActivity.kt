package pro.midev.ponyexpress.ui

import androidx.fragment.app.Fragment
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.extensions.themeIsDay
import pro.midev.supersld.ActivityBase

class AppActivity : ActivityBase() {

    override fun getStatusAndNavigationColor(): Pair<Int, Int> {
        return Pair(R.color.colorStatusBar, R.color.colorNavigationBar)
    }

    override fun getStartFragment(): Fragment {
        return Screens.FlowGlobal.fragment
    }

    override fun themeIsDay(): Boolean {
        return baseContext.themeIsDay()
    }
}