package pro.midev.ponyexpress.ui.main

import com.arellomobile.mvp.InjectViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.core.inject
import pro.midev.ponyexpress.controllers.BottomVisibilityController
import pro.midev.ponyexpress.controllers.ChangeBottomTabController
import pro.midev.supersld.common.base.BasePresenter
import timber.log.Timber

@InjectViewState
class MainContainerPresenter : BasePresenter<MainContainerView>() {

    private val changeBottomTabController: ChangeBottomTabController by inject()
    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun attachView(view: MainContainerView?) {
        super.attachView(view)
        bottomVisibilityController.show()
        viewState.initBottomNavigation()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        listenChangeBottomTab()
        listenBottomNavigationVisibility()
    }


    private fun listenChangeBottomTab() {
        changeBottomTabController.state
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    viewState.changeBottomTab(it)
                },
                {
                    Timber.e(it)
                }
            ).connect()
    }

    private fun listenBottomNavigationVisibility() {
        bottomVisibilityController.state
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    viewState.changeBottomNavigationVisibility(it)
                },
                {
                    Timber.e(it)
                }
            ).connect()
    }
}