package pro.midev.ponyexpress.ui.main.points.list
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment

class ListPointsFragment : BaseFragment(R.layout.fragment_list), MvpView {

    @InjectPresenter
    lateinit var presenter: ListPresenter
    private val adapter by lazy { ListPointsAdapter(presenter::openDetail) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvListPoints) {
            adapter = this@ListPointsFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}