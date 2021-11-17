package pro.midev.ponyexpress.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.common.MvpBottomSheetDialogFragment
import pro.midev.ponyexpress.common.enums.BottomSheetDialogType
import pro.midev.ponyexpress.ui.main.orders.departure_city.DepartureCityFragment
import pro.midev.supersld.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowGlobalFragment : FlowFragment(ROUTER), GlobalView {

    companion object {
        const val ROUTER = "APP_ROUTER"
    }

    @InjectPresenter
    lateinit var presenter: GlobalPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.Splash)
                )
            )
        }
    }

    override fun showBottomSheet(type: BottomSheetDialogType, data: Any?) {
        val bottomSheet: MvpBottomSheetDialogFragment = when (type) {
            BottomSheetDialogType.DEPARTURE_CITY -> DepartureCityFragment()
        }

        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }
}