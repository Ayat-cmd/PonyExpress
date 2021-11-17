package pro.midev.ponyexpress.ui.main

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import kotlinx.android.synthetic.main.fragment_main_container.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.Screens
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemBottomPadding
import ru.terrakok.cicerone.android.support.SupportAppScreen
import timber.log.Timber

class MainContainerFragment : BaseFragment(R.layout.fragment_main_container), MainContainerView {
    @InjectPresenter
    lateinit var presenter: MainContainerPresenter

    private val currentTabFragment: BaseFragment?
        get() = childFragmentManager.fragments.firstOrNull { !it.isHidden } as? BaseFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomNavigation.addSystemBottomPadding()
    }

    override fun initBottomNavigation() {
        childFragmentManager.fragments.clear()
        AHBottomNavigationAdapter(activity, R.menu.menu_bottom_navigation).apply {
            setupWithBottomNavigation(bottomNavigation)
        }

        with(bottomNavigation) {
            accentColor =
                    androidx.core.content.ContextCompat.getColor(context, R.color.colorAccentGreen1)
            inactiveColor =
                    androidx.core.content.ContextCompat.getColor(context, R.color.colorIconBlack20)
            titleState =
                    com.aurelhubert.ahbottomnavigation.AHBottomNavigation.TitleState.ALWAYS_SHOW

            setOnTabSelectedListener { position, wasSelected ->
                if (!wasSelected) {
                    arguments?.putInt(ARG_POSITION, position)
                    Timber.d("position $position")
                    selectTab(
                            when (position) {
                                0 -> ordersTab
                                1 -> pointsTab
                                2 -> notificationsTab
                                3 -> otherTab
                                else -> otherTab
                            }
                    )
                }
                true
            }

            selectTab(
                    when (arguments?.getInt(ARG_POSITION)!!) {
                        0 -> ordersTab
                        1 -> pointsTab
                        2 -> notificationsTab
                        3 -> otherTab
                        else -> otherTab
                    }
            )

            bottomNavigation.currentItem = arguments?.getInt(ARG_POSITION)!!

            Timber.d("selected tab ${arguments?.getInt(ARG_POSITION)!!}")
        }
    }

    private fun selectTab(tab: SupportAppScreen) {
        val currentFragment = currentTabFragment
        val newFragment = childFragmentManager.findFragmentByTag(tab.screenKey)

        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return

        childFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                createTabFragment(tab)?.let {
                    replace(
                        R.id.vgFragmentContainer,
                        it,
                        tab.screenKey
                    )
                }
            }
        }.commitNow()
    }

    private fun createTabFragment(tab: SupportAppScreen) = tab.fragment

    override fun changeBottomTab(screen: SupportAppScreen) {
        bottomNavigation.currentItem = when (screen) {
            ordersTab -> 0
            pointsTab -> 1
            notificationsTab -> 2
            otherTab -> 3
            else -> 3
        }
        arguments?.putInt(ARG_POSITION, bottomNavigation.currentItem)
        Timber.d("position ${bottomNavigation.currentItem}")
        bottomNavigation.currentItem
        selectTab(screen)
    }

    override fun changeBottomNavigationVisibility(isShow: Boolean) {
        bottomNavigation.visibility = if (isShow) View.VISIBLE else View.GONE
    }

    override fun onBackPressed() {
        currentTabFragment?.onBackPressed()
    }

    companion object {
        private val ordersTab = Screens.FlowOrders
        private val pointsTab = Screens.FlowPoints
        private val notificationsTab = Screens.FlowNotifications
        private val otherTab = Screens.FlowOther

        private const val ARG_POSITION = "arg_position"

        fun create(): MainContainerFragment {
            val fragment = MainContainerFragment()
            val arg = Bundle()
            arg.putInt(ARG_POSITION, 0)
            fragment.arguments = arg

            return fragment
        }
    }

}