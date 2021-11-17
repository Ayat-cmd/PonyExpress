package pro.midev.ponyexpress.ui.main.points.list

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class ListPresenter : BasePresenter<MvpView>() {

    override fun attachView(view: MvpView?) {
        super.attachView(view)
    }

    fun openDetail() {
        router?.navigateTo(Screens.PointDetail)
    }

    fun back() {
        router?.exit()
    }
}