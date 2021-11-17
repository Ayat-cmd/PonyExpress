package pro.midev.ponyexpress.ui.main.points.filter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import org.koin.core.inject
import pro.midev.ponyexpress.Screens
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.supersld.common.base.BasePresenter

@InjectViewState
class MapFilterPresenter : BasePresenter<MvpView>() {

    override fun attachView(view: MvpView?) {
        super.attachView(view)
    }

    fun back() {
        router?.exit()
    }
}