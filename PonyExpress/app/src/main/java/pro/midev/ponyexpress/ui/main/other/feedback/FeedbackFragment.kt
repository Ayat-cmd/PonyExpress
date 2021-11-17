package pro.midev.ponyexpress.ui.main.other.feedback
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_feedback.*
import pro.midev.ponyexpress.R
import pro.midev.supersld.common.base.BaseFragment
import pro.midev.supersld.extensions.addSystemBottomPadding

class FeedbackFragment : BaseFragment(R.layout.fragment_feedback), MvpView {

    @InjectPresenter
    lateinit var presenter: FeedbackPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle(R.string.settings_feedback_title)
            onBack(this@FeedbackFragment::onBackPressed)
        }
        nested.addSystemBottomPadding()
        vgMain.addSystemBottomPadding()

        with(etMessage) {
            showTitle(R.string.settings_feedback_message)
            setMinLines(6)
            setHint("")
        }

        with(etEmail) {
            showTitle(R.string.settings_feedback_email_head)
            setActionDone(EditorInfo.IME_ACTION_DONE)
            setInputType(EditorInfo.TYPE_TEXT_VARIATION_EMAIL_ADDRESS)
            setHint("")
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}