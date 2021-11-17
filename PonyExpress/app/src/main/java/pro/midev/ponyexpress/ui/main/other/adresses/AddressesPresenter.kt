package pro.midev.ponyexpress.ui.main.other.adresses

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class AddressesPresenter : BasePresenter<MvpView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
    }

    fun detail() {
        router?.navigateTo(Screens.AddressesDetail)
    }

    fun add() {
        router?.navigateTo(Screens.AddAddresses)
    }

    fun back() {
        router?.exit()
    }
}