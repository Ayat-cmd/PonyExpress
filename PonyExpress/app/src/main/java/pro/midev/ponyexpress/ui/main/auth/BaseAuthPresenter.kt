package pro.midev.ponyexpress.ui.main.auth

import com.arellomobile.mvp.MvpView
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.ui.main.notifications.FlowNotificationsFragment
import pro.midev.ponyexpress.ui.main.orders.FlowOrdersFragment
import pro.midev.ponyexpress.ui.main.other.FlowOtherFragment
import pro.midev.ponyexpress.ui.main.points.FlowPointsFragment
import pro.midev.supersld.common.base.BasePresenter

open class BaseAuthPresenter<V : MvpView> : BasePresenter<V>() {
    fun close() {
        router?.newRootScreen(
            when (navigationHolder.currentRouterTag) {
                FlowOrdersFragment.ROUTER -> Screens.FlowOrders
                FlowPointsFragment.ROUTER -> Screens.FlowPoints
                FlowNotificationsFragment.ROUTER -> Screens.FlowNotifications
                FlowOtherFragment.ROUTER -> Screens.FlowOther
                else -> Screens.FlowOrders
            }
        )
    }
}