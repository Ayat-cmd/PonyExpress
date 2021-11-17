package pro.midev.ponyexpress.ui.main.orders.order_detail
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_notifications.*
import pro.midev.ponyexpress.R
import pro.midev.supersld.common.base.BaseFragment

class OrderDetailFragment : BaseFragment(R.layout.fragment_order_detail), MvpView {

    @InjectPresenter
    lateinit var presenter: OrderDetailPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vToolbar) {
            setTitle("№ 10–1001–1001")
            onBack(this@OrderDetailFragment::onBackPressed)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}