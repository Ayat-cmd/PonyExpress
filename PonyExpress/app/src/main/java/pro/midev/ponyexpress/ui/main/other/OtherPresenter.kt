package pro.midev.ponyexpress.ui.main.other

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class OtherPresenter : BasePresenter<MvpView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.show()
    }

    fun auth() = router?.replaceScreen(Screens.Auth)
    fun feedback() = router?.navigateTo(Screens.Feedback)
    fun addresses() = router?.navigateTo(Screens.Addresses)
    fun aboutApplication() = router?.navigateTo(Screens.AboutApplication)

    fun back() {
        router?.exit()
    }
}