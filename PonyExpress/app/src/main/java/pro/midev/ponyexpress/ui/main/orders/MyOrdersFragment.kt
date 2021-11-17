package pro.midev.ponyexpress.ui.main.orders
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_my_orders.*
import online.juter.supersld.view.input.selectors.JTHorizontalSwitch
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.extensions.hide
import pro.midev.ponyexpress.extensions.isAuth
import pro.midev.ponyexpress.extensions.show
import pro.midev.ponyexpress.ui.views.PonyInputView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemTopPadding

class MyOrdersFragment : BaseFragment(R.layout.fragment_my_orders), MvpView {

    @InjectPresenter
    lateinit var presenter: MyOrdersPresenter

    private val adapter by lazy { OrdersAdapter(presenter::openOrder) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coordinator.addSystemTopPadding()

        with(rvOrders) {
            adapter = this@MyOrdersFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }

        with(vSwitch) {
            init(
                listOf("Ожидаю", "Отправленные"),
                params = JTHorizontalSwitch.JTSwitchParams(
                    fontPadding = 24,
                    fontSize = 16,
                    fontFamily = R.font.roboto_medium
                )
            )
        }

        with(vSearchInput) {
            setHint(R.string.orders_search_hint)
            addEndAction(
                PonyInputView.Action(
                    iconId = R.drawable.ic_search_input,
                    action = { text ->

                    }
                )
            )
            secondVariant()
            setActionDone(EditorInfo.IME_ACTION_SEARCH)
            setMaxLines(1)
            setPrefix("№")
            setDigits("0123456789№- ")
            setTextMask("[00]-[0000]-[0000]", false)
        }

        btnCreate.setOnClickListener {
            presenter.addOrder()
        }

        if (requireContext().isAuth()) {
            context?.isAuth()
            btnCreate.hide()
            tvListTitle.hide()
            tvListSubtitle.hide()
            vSwitch.hide()
            rvOrders.hide()
            vgNotAuth.show()
            coordinator.isEnabled = false
            btnAuth.setOnClickListener {
                presenter.auth()
            }
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}