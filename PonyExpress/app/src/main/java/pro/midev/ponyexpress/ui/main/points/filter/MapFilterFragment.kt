package pro.midev.ponyexpress.ui.main.points.filter
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_map_filter.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment

class MapFilterFragment : BaseFragment(R.layout.fragment_map_filter), MvpView {

    @InjectPresenter
    lateinit var presenter: MapFilterPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vToolbar) {
            setTitle(R.string.points_filter_title)
            setTextAction(
                ToolbarView.Action(R.string.points_filter_confirm, {})
            )
            onBack(this@MapFilterFragment::onBackPressed, R.drawable.ic_close)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}