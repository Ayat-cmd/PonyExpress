package pro.midev.ponyexpress.ui.main.other.adresses.address_detail
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_addresses.*
import kotlinx.android.synthetic.main.fragment_feedback.*
import kotlinx.android.synthetic.main.fragment_feedback.vToolbar
import kotlinx.android.synthetic.main.fragment_point_detail.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemBottomPadding

class DetailAddressesFragment : BaseFragment(R.layout.fragment_address_detail), MvpView {

    @InjectPresenter
    lateinit var presenter: DetailAddressesPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle("Дом")
            onBack(this@DetailAddressesFragment::onBackPressed)
        }

        vgButtons.addSystemBottomPadding()
    }

    override fun onBackPressed() {
        presenter.back()
    }
}