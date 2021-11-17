package pro.midev.ponyexpress.ui.main.points.map
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_notifications.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment

class MapFragment : BaseFragment(R.layout.fragment_map), MvpView {

    @InjectPresenter
    lateinit var presenter: MapPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onBackPressed() {
        presenter.back()
    }
}