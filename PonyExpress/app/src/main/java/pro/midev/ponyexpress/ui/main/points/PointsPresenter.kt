package pro.midev.ponyexpress.ui.main.points

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class PointsPresenter : BasePresenter<MvpView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    override fun attachView(view: MvpView?) {
        super.attachView(view)
        bottomVisibilityController.show()
    }

    fun filterPoint() {
        router?.navigateTo(Screens.PointFilter)
    }

    fun searchPoint() {
        router?.navigateTo(Screens.PointSearch)
    }

    fun back() {
        router?.exit()
    }
}