package pro.midev.ponyexpress.ui.main.orders.add_order

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.common.base.BottomSheetDialogController
import pro.midev.ponyexpress.common.enums.BottomSheetDialogType
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class AddOrderPresenter : BasePresenter<MvpView>() {

    private val bottomSheetDialogController: BottomSheetDialogController by inject()

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
    }
    fun onAddOrderClick() {
        bottomSheetDialogController.show(BottomSheetDialogType.DEPARTURE_CITY)
    }

    fun back() {
        router?.exit()
    }
}