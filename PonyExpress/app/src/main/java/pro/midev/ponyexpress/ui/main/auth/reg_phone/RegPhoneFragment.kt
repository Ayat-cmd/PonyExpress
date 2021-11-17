package pro.midev.ponyexpress.ui.main.auth.reg_phone
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_auth.*
import kotlinx.android.synthetic.main.fragment_reg_phone.*
import kotlinx.android.synthetic.main.fragment_reg_phone.btnLogin
import kotlinx.android.synthetic.main.fragment_reg_phone.etPhone
import kotlinx.android.synthetic.main.fragment_reg_phone.icClose
import kotlinx.android.synthetic.main.fragment_reg_phone.vgContainer
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.PonyInputView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemTopAndBottomPadding

class RegPhoneFragment : BaseFragment(R.layout.fragment_reg_phone), MvpView {

    @InjectPresenter
    lateinit var presenter: RegPhonePresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vgContainer.addSystemTopAndBottomPadding()

        icClose.setOnClickListener { onBackPressed() }
        linkText.movementMethod = LinkMovementMethod.getInstance()
        with(etPhone) {
            showTitle(R.string.auth_number)
            setPrefix("+7")
            setDigits("0123456789()-+ ")
            setImeAction(PonyInputView.ImeAction(EditorInfo.IME_ACTION_DONE) {

            })
            setTextMask("([000]) [000]-[00]-[00]")
            onValidChange { b, s, s2 ->
                btnLogin.isEnabled = b
            }
        }
        btnLogin.setOnClickListener {
            presenter.openSmsCode()
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}