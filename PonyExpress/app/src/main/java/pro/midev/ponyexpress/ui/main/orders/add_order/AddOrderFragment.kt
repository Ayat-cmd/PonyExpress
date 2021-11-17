package pro.midev.ponyexpress.ui.main.orders.add_order
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_add_order.*
import kotlinx.android.synthetic.main.fragment_address_add.*
import kotlinx.android.synthetic.main.fragment_address_add.vCity
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.vToolbar
import pro.midev.ponyexpress.R
import pro.midev.supersld.common.base.BaseFragment

class AddOrderFragment : BaseFragment(R.layout.fragment_add_order), MvpView {

    @InjectPresenter
    lateinit var presenter: AddOrderPresenter

    private var adapter = presenter::onAddOrderClick

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vToolbar) {
            setTitle("Рассчитать и отправить")
            onBack(this@AddOrderFragment::onBackPressed)
        }

        with(vCity) {
            setTitle("Город")
            hideDivider()
        }

        with(vCityTo) {
            setTitle("Город")
            hideDivider()
        }
        with(vDate) {
            setTitle("Возможная дата")
            hideDivider()
        }
        with(vOrder) {
            setTitle("Размеры и вес отправления")
            hideDivider()
        }
        with(ivPrice) {
            setPrefix("₽")
            setHint("")
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}