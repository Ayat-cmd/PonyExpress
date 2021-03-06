package pro.midev.ponyexpress.ui.main.orders

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class MyOrdersPresenter : BasePresenter<MvpView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.show()
    }

    fun auth() {
        router?.replaceScreen(Screens.Auth)
    }

    fun openOrder() {
        router?.navigateTo(Screens.OrderDetail)
    }

    fun addOrder() {
        router?.navigateTo(Screens.AddOrder)
    }

    fun back() {
        router?.exit()
    }
}