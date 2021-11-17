package pro.midev.ponyexpress.ui.main.points.point_detail
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.ListFragment
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.vToolbar
import kotlinx.android.synthetic.main.fragment_point_detail.*
import kotlinx.android.synthetic.main.fragment_points.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.main.points.list.ListPointsFragment
import pro.midev.ponyexpress.ui.main.points.map.MapFragment
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemBottomPadding

class PointDetailFragment : BaseFragment(R.layout.fragment_point_detail), MvpView {

    @InjectPresenter
    lateinit var presenter: PointDetailPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle("Экспресс-центр")
            onBack(this@PointDetailFragment::onBackPressed)
        }

        vgButtons.addSystemBottomPadding()
    }

    override fun onBackPressed() {
        presenter.back()
    }
}