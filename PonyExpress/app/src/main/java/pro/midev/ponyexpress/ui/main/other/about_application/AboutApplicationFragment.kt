package pro.midev.ponyexpress.ui.main.other.about_application
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_about_application.*
import pro.midev.ponyexpress.R
import pro.midev.supersld.common.base.BaseFragment

class AboutApplicationFragment : BaseFragment(R.layout.fragment_about_application), MvpView {

    @InjectPresenter
    lateinit var presenter: AboutApplicationPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(vToolbar) {
            setTitle(R.string.settings_btn_info)
            onBack(this@AboutApplicationFragment::onBackPressed)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}