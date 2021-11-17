package pro.midev.ponyexpress.ui.main.auth
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_auth.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.ui.views.PonyInputView
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemTopAndBottomPadding

class AuthFragment : BaseFragment(R.layout.fragment_auth), MvpView {

    @InjectPresenter
    lateinit var presenter: AuthPresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vgContainer.addSystemTopAndBottomPadding()
        icClose.setOnClickListener { onBackPressed() }

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

        with(etPassword) {
            showTitle(R.string.auth_password)
            setImeAction(PonyInputView.ImeAction(EditorInfo.IME_ACTION_DONE) {

            })
            setHint("")
            setInputType(InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD)
        }

        openReg.setOnClickListener {
            presenter.openRegistration()
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}