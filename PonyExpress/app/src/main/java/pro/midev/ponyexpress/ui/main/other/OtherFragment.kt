package pro.midev.ponyexpress.ui.main.other
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_notifications.btnAuth
import kotlinx.android.synthetic.main.fragment_notifications.vToolbar
import kotlinx.android.synthetic.main.fragment_other.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.extensions.isAuth
import pro.midev.ponyexpress.ui.views.ToolbarView
import pro.midev.supersld.common.base.BaseFragment

class OtherFragment : BaseFragment(R.layout.fragment_other), MvpView {

    @InjectPresenter
    lateinit var presenter: OtherPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle(R.string.settings_title)
        }
        btnAuth.setOnClickListener {
            presenter.auth()
        }
        btnFeedback.setOnClickListener {
            presenter.feedback()
        }

        btnAddresses.setOnClickListener {
            presenter.addresses()
        }

        btnAboutApplication.setOnClickListener  {
            presenter.aboutApplication()
        }



        if (requireContext().isAuth()) {
            vgNotAuth.visibility = View.GONE
        } else {
            vgAuth.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}