package pro.midev.ponyexpress.ui.main.auth.reg_sms_code

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.ponyexpress.ui.main.auth.BaseAuthPresenter

@InjectViewState
class RegSmsCodePresenter : BaseAuthPresenter<MvpView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
    }

    fun back() {
        router?.exit()
    }
}