package pro.midev.ponyexpress.ui.main.other.adresses
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_addresses.*
import kotlinx.android.synthetic.main.fragment_feedback.*
import kotlinx.android.synthetic.main.fragment_feedback.vToolbar
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemBottomPadding

class AddressesFragment : BaseFragment(R.layout.fragment_addresses), MvpView {

    @InjectPresenter
    lateinit var presenter: AddressesPresenter
    private val adapter by lazy { AddressesAdapter(presenter::detail) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle(R.string.settings_addresses_title)
            onBack(this@AddressesFragment::onBackPressed)
            setFirstAction(ToolbarView.Action(
                resId = R.drawable.ic_search,
                action = {}
            ))
        }

        with(rvAddresses) {
            adapter = this@AddressesFragment.adapter
            layoutManager = LinearLayoutManager(context)
            addSystemBottomPadding()
        }

        btnAddNew.setOnClickListener {
            presenter.add()
        }

        vgBottomButton.addSystemBottomPadding()
    }

    override fun onBackPressed() {
        presenter.back()
    }
}