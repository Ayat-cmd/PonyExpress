package pro.midev.ponyexpress.ui.main.auth.reg_sms_code
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_reg_sms_code.*
import pro.midev.ponyexpress.R
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemTopAndBottomPadding

class RegSmsCodeFragment : BaseFragment(R.layout.fragment_reg_sms_code), MvpView {

    @InjectPresenter
    lateinit var presenter: RegSmsCodePresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vgContainer.addSystemTopAndBottomPadding()

        icClose.setOnClickListener { onBackPressed() }

    }

    override fun onBackPressed() {
        presenter.back()
    }
}