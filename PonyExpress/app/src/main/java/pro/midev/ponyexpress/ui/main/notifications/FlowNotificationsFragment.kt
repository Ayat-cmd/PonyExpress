package pro.midev.ponyexpress.ui.main.notifications

import android.os.Bundle
import pro.midev.ponyexpress.Screens
import pro.midev.supersld.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowNotificationsFragment : FlowFragment(ROUTER) {

    companion object {
        const val ROUTER = "NOTIFICATIONS_ROUTER"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.Notifications)
                )
            )
        }
    }
}