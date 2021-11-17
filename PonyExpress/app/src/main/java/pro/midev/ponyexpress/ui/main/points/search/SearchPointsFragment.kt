package pro.midev.ponyexpress.ui.main.points.search
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_search_point.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.main.points.list.ListPointsAdapter
import pro.midev.supersld.common.base.BaseFragment

class SearchPointsFragment : BaseFragment(R.layout.fragment_search_point), MvpView {

    @InjectPresenter
    lateinit var presenter: SearchPointsPresenter
    private val adapter by lazy { ListPointsAdapter(presenter::openDetail) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vToolbar.onBack(this::onBackPressed)

        with(rvListPoints) {
            adapter = this@SearchPointsFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}