package pro.midev.ponyexpress.ui.main.auth.reg_phone

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.ponyexpress.ui.main.auth.BaseAuthPresenter

@InjectViewState
class RegPhonePresenter : BaseAuthPresenter<MvpView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
    }

    fun openSmsCode() {
        router?.navigateTo(Screens.RegSmsCode)
    }

    fun back() {
        router?.exit()
    }
}