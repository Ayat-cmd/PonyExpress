package pro.midev.ponyexpress.ui.main.notifications
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_notifications.*
import pro.midev.ponyexpress.R
import pro.midev.ponyexpress.extensions.isAuth
import pro.midev.ponyexpress.extensions.withVisible
import pro.midev.ponyexpress.models.local.NotificationLocal
import pro.midev.ponyexpress.models.local.NotificationLocal.Companion.ERROR
import pro.midev.ponyexpress.models.local.NotificationLocal.Companion.FINISH
import pro.midev.ponyexpress.models.local.NotificationLocal.Companion.WAITED
import pro.midev.supersld.common.base.BaseFragment

class NotificationsFragment : BaseFragment(R.layout.fragment_notifications), MvpView {

    @InjectPresenter
    lateinit var presenter: NotificationsPresenter
    private val adapter by lazy { NotificationsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vToolbar.setTitle(R.string.notifications_title)
        btnAuth.setOnClickListener {
            presenter.auth()
        }

        if (!requireContext().isAuth()) {
            vgNotAuth withVisible View.GONE
            rvNotifications withVisible View.VISIBLE
        }

        with(rvNotifications) {
            adapter = this@NotificationsFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }

        adapter.addAll(mutableListOf(
            NotificationLocal(
                id = "123",
                title = "Доставлено",
                date = "23.08.2021 10:43",
                text = "Тестовое уведомление",
                status = FINISH
            ),
            NotificationLocal(
                id = "123",
                title = "Заказ потеряли",
                date = "20.08.2021 11:43",
                text = "Тестовое уведомление",
                status = ERROR
            ),
            NotificationLocal(
                id = "123",
                title = "Все ок",
                date = "20.08.2021 13:43",
                text = "Тестовое уведомление",
                status = FINISH
            ),
            NotificationLocal(
                id = "123",
                title = "Скоро потеряем",
                date = "20.08.2021 14:43",
                text = "Тестовое уведомление",
                status = WAITED
            ),
            NotificationLocal(
                id = "123",
                title = "Доставлено",
                date = "21.08.2021 10:43",
                text = "Тестовое уведомление",
                status = FINISH
            )
        ))
    }

    override fun onBackPressed() {
        presenter.back()
    }
}